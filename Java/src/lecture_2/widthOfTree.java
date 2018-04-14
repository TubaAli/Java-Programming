#include<bits/stdc++.h>
using namespace std;

struct node
{
    int data;
    struct node* left;
    struct node* right;
};
int Height(node* root);
int getWidth(node* root, int level);
int getMaxWidth(node* root){
    int width;
    int maxWidth = 0;
    int h = Height(root);
    
    for(int i = 0; i<=h; i++){
        int width = getWidth(root,i);  //width of each level
        if(width>maxWidth)
            maxWidth = width;
    }
    return maxWidth;
}

int getWidth(struct node* root, int level){
    if(root==NULL)
        return 0;
    if(level==1)
        return 1;
    else if(level>1)
        return getWidth(root->left, level-1) + 
             getWidth(root->right, level-1);
    return 0;
}

int Height(node* root){
    if(root==NULL)
        return 0;
    else{
        int lheight = Height(root->left);
        int rheight = Height(root->right);
        
        if(lheight>rheight)
            return lheight+1;
        else return rheight+1;
    }
}

struct node* newNode(int data)
{
  struct node* node = (struct node*)
                       malloc(sizeof(struct node));
  node->data = data;
  node->left = NULL;
  node->right = NULL;
  return(node);
}

int main()
{
  struct node *root = newNode(1);
  root->left        = newNode(2);
  root->right       = newNode(3);
  root->left->left  = newNode(4);
  root->left->right = newNode(5);
  root->right->right = newNode(8);    
  root->right->right->left  = newNode(6);    
  root->right->right->right  = newNode(7);      

  printf("Maximum width is %d \n", getMaxWidth(root));  
  getchar();
  return 0;
}