#include <cstdlib>
#include <cstdio>
#include <iostream>

using namespace std;

class A {
public:
     A() {
	  cout<< "print in construct function"<<endl;
     }

     void doSomething() {
	  cout<<"do something in A class"<<endl;
     }
};

class B: A
{
public:
     void doSomething() {
	  cout<<"do something in B class"<<endl;
     }
};

int main(int argc, char ** argv)
{
     B bobject;

     bobject.doSomething();
}
     
