public class DobleEnlace {
    private Node head;
    private Node tail;

    public void addNode(Node node){
        if(head==null){
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
    }

    //Añadir al jugador a la lista de preguntas
    public void addPlayer(Player player){
        head.setPlayer(player);
    }

    //Activación
    public void askQuestion(String nameNode){
        askQuestion(head, nameNode);
    }

    //Recursivo
    public void askQuestion(Node current, String nameNode){
        if(current == null){
            System.out.println("Pregunta no encontrada");
            return;
        }if(current.getName().equals(nameNode)){
            System.out.println("Cuánto es: " + current.getQuestion() + " ?");
            return;
        }
        askQuestion(current.getNext(), nameNode);
    }

    //Activación
    public void score(int n, int questionPass, String namePlayer){
        scoreString(head, n, questionPass, namePlayer);
    }

    //Recursividad
    public int score(Node current, int n){
        if(current == null){
            return 1;
        }
        if(current.getStatus() == Status.INCORRECT){
            System.out.println(current.getQuestion() + " INCORRECTO");
        }
        System.out.println(current.getQuestion() + " CORRECTO");
        return score(current.getNext(), n + 1);
    }

    //Conversión a String
    public void scoreString(Node current, int n, int questionPass, String namePlayer){
        String score = String.valueOf(score(current, n) - questionPass);
        System.out.println(namePlayer + ", su puntaje fue: " + score);
    }

    //Activación
    public void checkAnswer(String nameNode, String answer, Player player){
        checkAnswer(head, nameNode, answer, player);
    }

    //Revursividad
    public void checkAnswer(Node current, String nameNode, String answer, Player player){
        if(current == null){
            return;
        }
        if(current.getName().equals(nameNode)){
            if(String.valueOf(current.getAnswer()).equals(answer)){
                current.setStatus(Status.CORRECT);
                if(current.getNext() != null){
                    Node nodeTemp = current.getNext();
                    nodeTemp.setPlayer(player);
                    current.setPlayer(null);
                }
                return;
            } else if (answer.equalsIgnoreCase("PASO")) {
                if (head == tail) { // Caso especial: solo hay un nodo en la lista
                    head = tail = null; // Establece la cabeza y la cola en null
                }else if(current == head){
                    Node next = head.getNext();
                    next.setPrevious(null);
                    head = next;
                }else if(current == tail){
                    Node prev = tail.getPrevious();
                    prev.setNext(null);
                    tail = prev;
                }else{
                    // Elimina un nodo intermedio
                    Node prev = current.getPrevious();
                    Node next = current.getNext();
                    prev.setNext(next);
                    next.setPrevious(prev);
                }
                return;
            }else {
                current.setStatus(Status.INCORRECT);
                if(current.getNext() != null){
                    Node nodeTemp = current.getNext();
                    nodeTemp.setPlayer(player);
                    current.setPlayer(null);
                }
                return;
            }
        }
        checkAnswer(current.getNext(), nameNode, answer, player);
    }

    //Activacion
    public void print(){
        print(head);
    }

    //Recursivo
    private void print(Node current){
        if(current == null){
            return;
        } else if (current.getPlayer() != null) {
            System.out.print("[" + current.getName() + "*] ");
        }else {
            if(current.getStatus() == Status.INCORRECT){
                System.out.print("[X] ");
            } else if (current.getStatus() == Status.CORRECT) {
                System.out.print("[+] ");
            } else {
                System.out.print("[" + current.getName() + "] ");
            }
        }
        print(current.getNext());
    }
}
