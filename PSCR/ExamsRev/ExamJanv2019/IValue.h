//
// Created by adrien on 23/12/2019.
//

#pragma once
class IValue {
public :
    virtual void set (int val) = 0;
    virtual int get () const = 0;
    virtual ~IValue() {}
};
class Value : public IValue {
    int val;
public :
    Value (int v=0):val(v) {}
    void set (int v) { val = v; }
    int get () const { return val; }
    ~Value() {}
};