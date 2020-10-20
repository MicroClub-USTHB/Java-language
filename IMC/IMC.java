import java.util.*;  
class IMC  
{  
public static void main(String[] args)  
{  

Scanner sc= new Scanner(System.in); 
System.out.print("\nEnter your weight (kg): ");  
String str= sc.nextLine(); 

Double w=Double.parseDouble(str);             //reads string  
 


Scanner s= new Scanner(System.in); 
System.out.print("\nEnter your height (m): ");  
String sth= s.nextLine();

Double h=Double.parseDouble(sth);  

Double imc=w/(h*h);

	System.out.print("\n-------------- Votre indice de masse corpoelle est : "+imc+" --------------------\n"); 

if(imc <16.5)
	System.out.print("\n Dénutrition ou anorexie\n"); 
if(imc >=16.5 && imc<18.5)
	System.out.print("\n Maigreur\n"); 
if(imc >=18.5 && imc<25)
{System.out.print("\n Poids normal\n"); }
if(imc >=25 && imc<30)
	System.out.print("\n Surpoids\n"); 
if(imc >=30 && imc<35)
	System.out.print("\n Obesite moderee\n"); 
if(imc >=35 && imc<40)
	System.out.print("\n Obesite severe\n");
if( imc>40)
	System.out.print("\n Obesite morbide ou massive\n"); 


	System.out.print("\n ------------------------------------------------------\n\nIMC (kg x m-2)  |\tInterpretation \n"); 
	System.out.print("\n Moins de 16,5 \t| Denutrition ou anorexie"); 
	System.out.print("\n 16,5 a 18,5 \t| Maigreur"); 
	System.out.print("\n 18,5 a 25 \t| Poids normal"); 
	System.out.print("\n 25 a 30 \t| Surpoids"); 
	System.out.print("\n 30 a 35 \t| Obesite moderee"); 
	System.out.print("\n 35 a 40 \t| Obesite severe"); 
	System.out.print("\n Plus de 40 \t| Obesite morbide ou massive\n\n"); 
	
 	






            
}  
}  