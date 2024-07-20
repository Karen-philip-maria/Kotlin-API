package com.example.postsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAppAdapter (var postsLists:List<Post>):
RecyclerView.Adapter<PostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int):PostViewHolder {
        val itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.posts_list_item, parent, false)
        return  PostViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:PostViewHolder, position: Int) {
val post= postsLists[position]
        holder.body.text=post.body
        holder.title.text= post.title
//        holder.userId.text= "userID: ${post.userId}"
//        holder.id.text= "Id: ${post.id}"
    }

    override fun getItemCount(): Int {
    return postsLists.size
    }


}
class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
 var body = itemView.findViewById<TextView>(R.id.body)
   var title = itemView.findViewById<TextView>(R.id.userTitle)
//    var id = itemView.findViewById<TextView>(R.id.userId)
//    var userId = itemView.findViewById<TextView>(R.id.id)
}
