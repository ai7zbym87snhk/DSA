#include <stdio.h>
#include <stdlib.h>

// Define a structure for a node in the linked list
struct Node {
  int data;
  struct Node* next;
};

// Function to insert a new node at the beginning of the linked list
void push(struct Node** head_ref, int new_data) {
  struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
  new_node->data = new_data;
  new_node->next = *head_ref;
  *head_ref = new_node;
}

// Function to reverse the linked list
void reverse(struct Node** head_ref) {
  struct Node* prev = NULL;
  struct Node* current = *head_ref;
  struct Node* next = NULL;

  while (current != NULL) {
    next = current->next;  // Save the next node
    current->next = prev;  // Change next of current node
    prev = current;        // Move prev to the current node
    current = next;        // Move to the next node
  }

  *head_ref = prev;  // Change the head to the last node (new first node)
}

// Function to print the linked list
void printList(struct Node* head) {
  struct Node* temp = head;
  while (temp != NULL) {
    printf("%d -> ", temp->data);
    temp = temp->next;
  }
  printf("NULL\n");
}

int main() {
  struct Node* head = NULL;
  push(&head, 3);
  push(&head, 7);
  push(&head, 9);
  push(&head, 2);

  printf("Original linked list: ");
  printList(head);

  reverse(&head);

  printf("Reversed linked list: ");
  printList(head);

  return 0;
}
