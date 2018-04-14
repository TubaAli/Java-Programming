/* C Program to remove duplicates from a sorted linked list */
#include<stdio.h>
#include<stdlib.h>
 
/* Link list node */
struct Node
{
    int data;
    struct Node* next;
};

void removeDuplicates(Node* head){
    Node* current = head;
    Node* next_next;
    
    if(current==NULL)
        return;
    
    while(current->next!=NULL){
        if(current->data==current->next->data){
            next_next=current->next->next;
            free(current->next);
            current->next=next_next;
        }
        else{
            current = current->next;
        }
    }
}

void push(struct Node** head_ref, int new_data)
{
    /* allocate node */
    struct Node* new_node =
            (struct Node*) malloc(sizeof(struct Node));
             
    /* put in the data  */
    new_node->data  = new_data;
                 
    /* link the old list off the new node */
    new_node->next = (*head_ref);     
         
    /* move the head to point to the new node */
    (*head_ref)    = new_node;
}
 
/* Function to print nodes in a given linked list */
void printList(struct Node *node)
{
    while (node!=NULL)
    {
       printf("%d ", node->data);
       node = node->next;
    }
} 
 
/* Drier program to test above functions*/
int main()
{
    /* Start with the empty list */
    struct Node* head = NULL;
   
    /* Let us create a sorted linked list to test the functions
     Created linked list will be 11->11->11->13->13->20 */
    push(&head, 20);
    push(&head, 13);
    push(&head, 13);  
    push(&head, 11);
    push(&head, 11);
    push(&head, 11);                                    
 
    printf("\n Linked list before duplicate removal  ");
    printList(head); 
 
    /* Remove duplicates from linked list */
    removeDuplicates(head); 
 
    printf("\n Linked list after duplicate removal ");         
    printList(head);            
   
    return 0;
}