import java. util. Scanner ;
public class Main {
 public static void main( String [] args) {
 Scanner scan = new Scanner ( System . in );
System . out . println( "Enter a letter:" );
 String letter = scan. next ();
if ( letter. toUpperCase(). equals( "Y" )) {
 System . out . println( "Yes" );
 } else if ( letter. toUpperCase(). equals( "N" )) {
 System . out . println( "No" );
 } else {
 System . out . println( "Invalid letter" );
 }
 } }