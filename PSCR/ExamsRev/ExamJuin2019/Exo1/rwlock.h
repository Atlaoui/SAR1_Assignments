//
// Created by adrien on 27/12/2019.
//

#ifndef EXAMSREV_RWLOCK_H
#define EXAMSREV_RWLOCK_H
class RWLock {
public :
    virtual void rlock()=0; // reader lock
    virtual void runlock()=0; // reader unlock
    virtual void wlock()=0; // writer lock
    virtual void wunlock()=0; // writer unlock
    virtual ~RWLock(){}
};
#endif //EXAMSREV_RWLOCK_H
