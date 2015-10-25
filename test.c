/**
 Plan na razie taki, 
	Coś sie tutaj jednak dzieje :P
*/

#include<stdio.h>
#include<math.h>
#include<ctype.h>
char pp[10000];
char kk[10000];
char code[100000];
char ch1[10000];
char ch2[10000];
char ch3[10000];
int place = 0, place2;
char totake[8];
char* convert(int t, int y){
	int i = 0, signum = 0, e, f = 7, value = 0, place = 0, ii;
	char sign[8];
	place = y;
	for(i = 0; i < t; i++){
		if(code[i] == ' '){
			i = i + 1; 
			continue;
		}else{
			sign[signum] = code[i];
			signum = signum+1;
			//printf("%d ", place);
			if(signum == 8){
				signum = 0;
				//for(ii = 0; ii < 8; ii++){
				//	printf("%d", sign[ii]);
				//}
				//printf(" ");
				for(e = 0; e < 8; e++){
					if(sign[e] == 1){
						value = value + pow(2, f);
						f = f - 1;
					}else f = f - 1;
				}
			//	printf("%c", value);
				f = 7;
				if(isalpha(value) || value == '!' || value == '.' || value == '?' || value ==','){
				//	
					ch1[place] = value;
				//	printf("%c", ch1[place]);
					place = place + 1;
				//	printf("%d ", place);
				}else place = place + 1;
				value = 0;
			}
		}
	}
//	printf("\n");
	return ch1;
}
int main(int argc, char* argv)
{
	FILE* f[20];
	FILE* p;
	int counter = 0, counter2 = 0, i, jj = 0, jjj = 0, quantity = 0, toput = 0, toput2 = 0, u, jj2 = 0;
	int length1, length2;
	int number;
	char m;
	char* pointer;
	
	f[0] = fopen("krypt1.txt", "r");
	f[1] = fopen("krypt2.txt", "r");
	f[2] = fopen("krypt3.txt", "r");
	f[3] = fopen("krypt4.txt", "r");
	f[4] = fopen("krypt5.txt", "r");
	f[5] = fopen("krypt6.txt", "r");
	f[6] = fopen("krypt7.txt", "r");
	f[7] = fopen("krypt8.txt", "r");
	f[8] = fopen("krypt9.txt", "r");
	f[9] = fopen("krypt10.txt", "r");
	f[10] = fopen("krypt11.txt", "r");
	f[11] = fopen("krypt12.txt", "r");
	f[12] = fopen("krypt13.txt", "r");
	f[13] = fopen("krypt14.txt", "r");
	f[14] = fopen("krypt15.txt", "r");
	f[15] = fopen("krypt16.txt", "r");
	f[16] = fopen("krypt17.txt", "r");
	f[17] = fopen("krypt18.txt", "r");
	f[18] = fopen("krypt19.txt", "r");
	f[19] = fopen("krypt20.txt", "r");
	
	p = fopen("kod.txt", "r");
	for(i = 0; i < 5; i++){  //zczytuję pierwsze 5 znaków każdego z kryptogramów
	while(counter < 20){
		fscanf(f[counter], "%c", &number);
		pp[counter2] = number;
	//	printf("%c", pp[counter]);
		counter = counter + 1;
		counter2 = counter2 + 1;
	}
		counter = 0;
		printf("\n");
	}
	length1 = counter2;
	counter = 0;		
	for(jj = 0; jj < length1; jj++)
	while(!feof(p)){  //zczytuję kod
	
		fscanf(p, "%c", &number);
		kk[counter] = number;
		//printf("%c", kk[counter]);
		counter = counter+1;
	}
	length2 = counter;
	counter = 0;
	//convert2(length2);
	
	
	for(i = 0; i < length1; i++){
		totake[counter] = pp[i];
		counter = counter + 1;
		if(counter == 8){
		//for(jjj = 0; jjj < 8; jjj++){
	//		printf("%c", totake[jjj]);
	//	}
	//	printf("\n");
		counter = 0;
			for(jj = 0; jj < length2; jj++){
				if(kk[jj] != ' '){
				code[jj] = kk[jj]^totake[jj%8];
				//printf("%d", kk[jj]^totake[jj2]);
				}
				//else{ printf(" ");}
			}
			pointer = convert(length2, place);
			for( jjj = 0; jjj < 10000; jjj++){
				if(*(pointer + jjj) != 0){
				ch3[toput] = *(pointer + jjj);
				toput = toput + 1;
				}
				}

			}
			//quantity = convert(length2, place) + quantity;
		
			//printf("\n");
			//quantity = quantity + convert(length2, quantity);
		}
			for(toput2 = 1; toput2 <= 80; toput2++){
			printf("%d: ",toput2);
				for(u = 1; u < 10000; u++){
					if(toput2%u == 0 && ch3[u] != 0 && u!=0)
					printf("%c ", ch3[u]);
				}
				printf("\n");
			}
return 0;
}
