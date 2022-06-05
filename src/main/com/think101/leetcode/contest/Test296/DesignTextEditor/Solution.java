package main.com.think101.leetcode.contest.Test296.DesignTextEditor;

class Node {
    char c;
    Node prev;
    Node next;

    public Node(char c) {
        this.c = c;
    }
}

class TextEditor {

    private final Node cursor;

    public TextEditor() {
        cursor = new Node('0');
    }

    public void addText(String text) {
        Node cur;
        for(int i=0; i<text.length(); i++) {
            cur = new Node(text.charAt(i));
            cur.prev = cursor.prev;
            cursor.prev = cur;
        }
    }

    public int deleteText(int k) {
        for(int i=0; i<k; i++) {
            if(cursor.prev == null){
                return i;
            }

            cursor.prev = cursor.prev.prev;
            if(cursor.prev != null) {
                cursor.prev.next = cursor;
            }
        }

        return k;
    }

    public String cursorLeft(int k) {

        for(int i=0; i<k; i++){
            if(cursor.prev == null)
                break;

            Node t = cursor.prev;

            if(cursor.next != null)
                cursor.next.prev = t;
            t.next = cursor.next;

            cursor.next = t;
            cursor.prev = t.prev;
            if(cursor.prev != null)
                cursor.prev.next = cursor;
            t.prev = cursor;
        }

        return printText();
    }

    public String cursorRight(int k) {
        for(int i=0; i<k; i++){
            if(cursor.next == null)
                break;

            Node t = cursor.next;

            if(cursor.prev != null)
                cursor.prev.next = t;
            t.prev = cursor.prev;

            cursor.prev = t;
            cursor.next = t.next;
            if(cursor.next != null)
                cursor.next.prev = cursor;
            t.next = cursor;
        }

        return printText();
    }

    private String printText() {
        StringBuilder sb = new StringBuilder();
        Node cur = cursor.prev;
        for(int i=0; i<10; i++) {
            if(cur == null)
                break;

            sb.insert(0, cur.c);
            cur = cur.prev;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        te.addText("hello");
        System.out.println(te.cursorLeft(1));
        te.addText("world");
        System.out.println(te.cursorRight(1));
        te.addText("!");
        System.out.println(te.cursorRight(1));
    }
}