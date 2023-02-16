public class Node {

    private  Node next;
    private Node previous;
    private String name;
    private Player player;
    private String question;
    private int answer;
    private Status status;

    public Node(String name) {
        this.name = name;
        this.player = null;
        this.status = Status.NO_ANSWER;
        calculateOperation();
    }

    public void calculateOperation(){
        int value1 = (int)(Math.random()*(99)+1);
        int value2 = (int)(Math.random()*(99)+1);;
        int operatorRandom = (int)(Math.random()*(3)+1);
        if (operatorRandom == 1){
            question = "" + value1 + " + " + value2;
            answer = value1 + value2;
        }else if(operatorRandom == 2){
            question = "" + value1 + " - " + value2;
            answer = value1 - value2;
        }else {
            question = "" + value1 + " * " + value2;
            answer = value1 * value2;
        }
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrevious() {
        return previous;
    }

    public String getName() {
        return name;
    }

    public Player getPlayer() {
        return player;
    }

    public String getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public Status getStatus() {
        return status;
    }
}
