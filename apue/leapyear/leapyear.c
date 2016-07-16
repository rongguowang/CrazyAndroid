#include "stdio.h"
#include "stdlib.h"
#include "string.h"

int isLeapYear(int year)
{
     int retVal = 0;

     if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
     {
	  retVal = 1;
     }
     return retVal;
}

void printYear(int year[], int count)
{
     int i = 0;

     if (year == NULL)
	  return ;

     printf("size: %d\n", count);

     for (i = 0; i < count; i++)
     {
	  printf("%4d\t", year[i]);
     }
     printf("\n");
}

int main(int argc, char **argv)
{
     int year = 0;
     int mLeapYear[760], leapYear = 0;
     int mNLeapYear[2500], nleapYear = 0;

     memset(mLeapYear, 0, 760);
     memset(mNLeapYear, 0, 2500);

     for (year = 0; year <= 3000; year++)
     {
	  if (isLeapYear(year))
	  {
	       mLeapYear[leapYear]= year;
	       leapYear++;
	  } else 
	  {
	       mNLeapYear[nleapYear] = year;
	       nleapYear++;
	  }
     }

     printf("\n");
     printYear(mLeapYear, leapYear);
//     printYear(mNLeapYear, nleapYear);

}
