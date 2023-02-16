import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main (String[] args){
        DobleEnlace lista = new DobleEnlace();
        int questionPass = 0;

        System.out.println("Ingrese su nombre: ");
        String namePlayer = sc.next();
        Player player = new Player(namePlayer);

        System.out.println("Ingrese el número de preguntas que desea: ");
        int n = sc.nextInt();

        //Añadir node
        for (int i = 0; i < n; i++){
            lista.addNode(new Node(String.valueOf(i + 1)));
        }

        //Referenciar al jugador
        lista.addPlayer(player);

        for(int i = 0; i < n; i++){
            lista.print();
            System.out.println("");
            lista.askQuestion(String.valueOf(i+1));
            System.out.println("Ingrese \"1\" para para pasar la pregunta\nIngrese su respuesta: ");
            String answer = sc.next();
            if(answer.equalsIgnoreCase("PASO")){
                questionPass++;
            }
            lista.checkAnswer(String.valueOf(i+1), answer, player);
        }
        lista.print();
        System.out.println("");
        lista.score(0, questionPass, namePlayer);
    }


}
