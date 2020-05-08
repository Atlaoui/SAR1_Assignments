
/* Q2 */
public interface FSMaster extends Remote { 
   boolean create( String filename ) throws RemoteException ;
   boolean remove ( String filename ) throws RemoteException ; 
   List<blocmanager> getBlocManagers( String filename ) throws RemoteException ; 
   BlocManager allocateNewBloc( String filename) throws RemoteException ; 
}

/* Q3 */
public interface BlocManager extends Remote {
  /*renvoie le contenu d’un bloc, la taille du tableau en résultat est égal à la taille d’un bloc*/
  byte[] getBlocContent( String filename , int numbloc ) throws RemoteException;
  /*Permet d’ajouter nouveau bloc identifié par num pour un fichier */
  void addNewBloc( String filename , int num ) throws RemoteException;
  /*ecrit des données dans le bloc num du fichier filename et renvoi le nombre d'octet écrits*/
  int write( String filename , int num , byte[] data ) throws RemoteException;
  /*efface tous les blocs d’un fichier et renvoi le nombre de blocs effacé*/
  int removeBlocs( String filename ) throws RemoteException;
}


public class FSClient {
  private FSMaster master;
  public FSClient(FSMaster master) {
    this.master=master;
  }
  public boolean create(String name) throws RemoteException {
    return master.create(name);
  }
  public boolean remove(String name) throws RemoteException {
    return master.remove(name);
  }
  public boolean read(String name, int offset, byte[] buf) throws Exception {
    List<BlocManager> blk_manager = master.getBlocManagers(name);
    int offset_remaining = offset % 1024;
    int current_bloc=offset / 1024;
    int nb_byte_read=0;
    while(current_bloc < blk_manager.size() && nb_byte_read < buf.length) {
      int j=0;
      if(offset_remaining > 0) {
        j=offset_remaining;
        offset_remaining=0;
      }
      byte[] data = blk_manager.get(current_bloc).getBlocContent(name,current_bloc);
      while(nb_byte_read < buf.length && j < data.length) {
         buf[nb_byte_read]=data[j];
         j++;
         nb_byte_read++;
      }
    }
    return nb_byte_read==buf.length;
  }

  public void write(String name, int offset, byte[] buf) throws Exception {
    List<BlocManager> blk_manager = master.getBlocManagers(name);
    int offset_remaining = offset % 1024;
    int current_bloc=offset / 1024;
    int nb_byte_written=0;
    while(nb_byte_written < buf.length) {
      BlocManager current;
      if(current_bloc >= blk_manager.size()) {
        current = master.allocateNewBloc(name);
      }else {
        current= blk_manager.get(current_bloc);
      }
      byte[] data = current.getBlocContent(name, current_bloc);
      int j=0;
      if(offset_remaining > 0) {
        j=offset_remaining;
        offset_remaining=0;
      }
      while(nb_byte_written < buf.length && j < data.length) {
        data[j]=buf[nb_byte_written];
        j++;
        nb_byte_written++;
      }
      current.write(name, current_bloc, data);
      current_bloc++;
    }
  }
}


