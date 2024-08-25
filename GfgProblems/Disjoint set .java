class GfG
{
	int find(int A[],int X)
        {
         
         if(A[X]==X) return X;
         A[X]= find(A,A[X]);
         return A[X];
         
         
         
          
        }
	void unionSet(int A[],int X,int Z)
        {
         
         
         int rootX=find(A,X);
         int rootZ= find(A,Z);
         
         if(rootX != rootZ){
             A[rootX]=rootZ;
         }
	}
}
