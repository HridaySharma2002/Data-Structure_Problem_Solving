/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        InsertInBetween(head);
        connectrandompointers(head);
        return getDeepCopyList(head);
    }

    public void InsertInBetween(Node head){
        Node temp=head;
        while(temp!=null){
            Node nextelement=temp.next;
            Node copyNode=new Node(temp.val);
            copyNode.next=nextelement;
            temp.next=copyNode;
            temp=nextelement;
        }
    }

    public void connectrandompointers(Node head){
        Node temp=head;
        while(temp!=null){
            Node copyNode=temp.next;
            if(temp.random!=null){
                copyNode.random=temp.random.next;
            }
            else{
                copyNode.random=null;
            }
            temp=temp.next.next;
        }
    }

    public Node getDeepCopyList(Node head){
        Node temp=head;
        Node dummyNode=new Node(-1);
        Node res=dummyNode;
        while(temp!=null){
            res.next=temp.next;
            res=res.next;

            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummyNode.next;
    }
}
