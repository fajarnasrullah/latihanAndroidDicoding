//package com.jer.githubapp
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.bumptech.glide.request.RequestOptions
//import com.jer.githubapp.data.response.SearchUserResponse2Item
//import com.jer.githubapp.data.response.UserResponse2
//import com.jer.githubapp.data.response.UserResponse2Item
//import com.jer.githubapp.ui.MainViewModel
////class cobainadapter (val results : ArrayList<UserResponse2Item>) : RecyclerView.Adapter<cobainadapter.ViewHolder>()
//class cobainadapter (private val results: ArrayList<UserResponse2Item>, val context: Context) : RecyclerView.Adapter<cobainadapter.ListViewHolder>() {
//
//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
//
//    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bindItem(iniUser: UserResponse2Item) {
//            val imgPhoto: ImageView = itemView.findViewById(R.id.img_list)
//            val tvName: TextView = itemView.findViewById(R.id.username_list)
////            val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
//
////            val imgPhoto2: ImageView = itemView.findViewById((R.id.imageDesti))
////            val tvName2: TextView = itemView.findViewById((R.id.judulDesti))
////            val tvDescription2: TextView = itemView.findViewById((R.id.deskripsiDesti))
//
//            val imgUrl = iniUser.avatarUrl
//
//            tvName.text = iniUser.login
////            tvDescription.text = iniDesti.deskripsi_destinasi
//            imgPhoto.setImageResource(iniUser.id)
//
//            Glide.with(itemView.context)
//                .load(imgUrl)
//                .apply(RequestOptions().override(300, 300))
//                .into(imgPhoto)
////            tvName2.text = iniDesti.nama_destinasi
////            tvDescription2.text = iniDesti.deskripsi_destinasi
////            imgPhoto2.setImageResource(iniDesti.gambar_destinasi)
//        }
////        val imgHalaman: ImageView = itemView.findViewById(R.id.imageDesti)
////        val judulHalaman: TextView = itemView.findViewById(R.id.judulDesti)
////        val deskripsiHalaman: TextView = itemView.findViewById(R.id.deskripsiDesti)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view: View =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)
////        val view3: View = LayoutInflater.from(parent.context).inflate(R.layout.activity_halaman_wisata, parent, false)
//        return ListViewHolder(view)
////        return ListViewHolder(view3)
//    }
//
//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        holder.bindItem(results[position])
//    }
//
//    override fun getItemCount(): Int = results.size
//
//
//    companion object {
//
//        fun submitList(iniListList: List<SearchUserResponse2Item>) {
//
//        }
//
//        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SearchUserResponse2Item>() {
//            override fun areItemsTheSame(oldItem: SearchUserResponse2Item, newItem: SearchUserResponse2Item): Boolean {
//                return oldItem.id == newItem.id
//            }
//            override fun areContentsTheSame(oldItem: SearchUserResponse2Item, newItem: SearchUserResponse2Item): Boolean {
//                return oldItem == newItem
//            }
//        }
//
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data: UserResponse2Item)
//    }
//}
////class cobainadapter (val results : ArrayList<UserResponse2Item>) : RecyclerView.Adapter<cobainadapter.ViewHolder>(){
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
////        LayoutInflater.from(parent.context).inflate(R.layout.item_list_user,parent, false)
////    )
////
////    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
////        val result = results[position]
////        holder.view..text = result.title
////    }
////
////    override fun getItemCount() = results.size
////
////    class ViewHolder (val view : View) : RecyclerView.ViewHolder(view)
////}
//
////    [
////        {
////            "login": "fajarnasrullah",
////            "id": 108916878,
////            "node_id": "U_kgDOBn3wjg",
////            "avatar_url": "https://avatars.githubusercontent.com/u/108916878?v=4",
////            "gravatar_id": "",
////            "url": "https://api.github.com/users/fajarnasrullah",
////            "html_url": "https://github.com/fajarnasrullah",
////            "followers_url": "https://api.github.com/users/fajarnasrullah/followers",
////            "following_url": "https://api.github.com/users/fajarnasrullah/following{/other_user}",
////            "gists_url": "https://api.github.com/users/fajarnasrullah/gists{/gist_id}",
////            "starred_url": "https://api.github.com/users/fajarnasrullah/starred{/owner}{/repo}",
////            "subscriptions_url": "https://api.github.com/users/fajarnasrullah/subscriptions",
////            "organizations_url": "https://api.github.com/users/fajarnasrullah/orgs",
////            "repos_url": "https://api.github.com/users/fajarnasrullah/repos",
////            "events_url": "https://api.github.com/users/fajarnasrullah/events{/privacy}",
////            "received_events_url": "https://api.github.com/users/fajarnasrullah/received_events",
////            "type": "User",
////            "site_admin": false,
////            "score": 1.0
////        },
////
////        {
////            "login": "muhammad-ramdani",
////            "id": 93460086,
////            "node_id": "U_kgDOBZIWdg",
////            "avatar_url": "https://avatars.githubusercontent.com/u/93460086?v=4",
////            "gravatar_id": "",
////            "url": "https://api.github.com/users/muhammad-ramdani",
////            "html_url": "https://github.com/muhammad-ramdani",
////            "followers_url": "https://api.github.com/users/muhammad-ramdani/followers",
////            "following_url": "https://api.github.com/users/muhammad-ramdani/following{/other_user}",
////            "gists_url": "https://api.github.com/users/muhammad-ramdani/gists{/gist_id}",
////            "starred_url": "https://api.github.com/users/muhammad-ramdani/starred{/owner}{/repo}",
////            "subscriptions_url": "https://api.github.com/users/muhammad-ramdani/subscriptions",
////            "organizations_url": "https://api.github.com/users/muhammad-ramdani/orgs",
////            "repos_url": "https://api.github.com/users/muhammad-ramdani/repos",
////            "events_url": "https://api.github.com/users/muhammad-ramdani/events{/privacy}",
////            "received_events_url": "https://api.github.com/users/muhammad-ramdani/received_events",
////            "type": "User",
////            "site_admin": false,
////            "score": 1.0
////        },
////        {
////            "login": "indrakurr",
////            "id": 122657032,
////            "node_id": "U_kgDOB0-ZCA",
////            "avatar_url": "https://avatars.githubusercontent.com/u/122657032?v=4",
////            "gravatar_id": "",
////            "url": "https://api.github.com/users/indrakurr",
////            "html_url": "https://github.com/indrakurr",
////            "followers_url": "https://api.github.com/users/indrakurr/followers",
////            "following_url": "https://api.github.com/users/indrakurr/following{/other_user}",
////            "gists_url": "https://api.github.com/users/indrakurr/gists{/gist_id}",
////            "starred_url": "https://api.github.com/users/indrakurr/starred{/owner}{/repo}",
////            "subscriptions_url": "https://api.github.com/users/indrakurr/subscriptions",
////            "organizations_url": "https://api.github.com/users/indrakurr/orgs",
////            "repos_url": "https://api.github.com/users/indrakurr/repos",
////            "events_url": "https://api.github.com/users/indrakurr/events{/privacy}",
////            "received_events_url": "https://api.github.com/users/indrakurr/received_events",
////            "type": "User",
////            "site_admin": false,
////            "score": 1.0
////        },
////        {
////            "login": "jensakrom",
////            "id": 363937,
////            "node_id": "MDQ6VXNlcjM2MzkzNw==",
////            "avatar_url": "https://avatars.githubusercontent.com/u/363937?v=4",
////            "gravatar_id": "",
////            "url": "https://api.github.com/users/jensakrom",
////            "html_url": "https://github.com/jensakrom",
////            "followers_url": "https://api.github.com/users/jensakrom/followers",
////            "following_url": "https://api.github.com/users/jensakrom/following{/other_user}",
////            "gists_url": "https://api.github.com/users/jensakrom/gists{/gist_id}",
////            "starred_url": "https://api.github.com/users/jensakrom/starred{/owner}{/repo}",
////            "subscriptions_url": "https://api.github.com/users/jensakrom/subscriptions",
////            "organizations_url": "https://api.github.com/users/jensakrom/orgs",
////            "repos_url": "https://api.github.com/users/jensakrom/repos",
////            "events_url": "https://api.github.com/users/jensakrom/events{/privacy}",
////            "received_events_url": "https://api.github.com/users/jensakrom/received_events",
////            "type": "User",
////            "site_admin": false,
////            "score": 1.0
////        },
////
////        {
////            "login": "arissuryadi",
////            "id": 568314,
////            "node_id": "MDQ6VXNlcjU2ODMxNA==",
////            "avatar_url": "https://avatars.githubusercontent.com/u/568314?v=4",
////            "gravatar_id": "",
////            "url": "https://api.github.com/users/arissuryadi",
////            "html_url": "https://github.com/arissuryadi",
////            "followers_url": "https://api.github.com/users/arissuryadi/followers",
////            "following_url": "https://api.github.com/users/arissuryadi/following{/other_user}",
////            "gists_url": "https://api.github.com/users/arissuryadi/gists{/gist_id}",
////            "starred_url": "https://api.github.com/users/arissuryadi/starred{/owner}{/repo}",
////            "subscriptions_url": "https://api.github.com/users/arissuryadi/subscriptions",
////            "organizations_url": "https://api.github.com/users/arissuryadi/orgs",
////            "repos_url": "https://api.github.com/users/arissuryadi/repos",
////            "events_url": "https://api.github.com/users/arissuryadi/events{/privacy}",
////            "received_events_url": "https://api.github.com/users/arissuryadi/received_events",
////            "type": "User",
////            "site_admin": false,
////            "score": 1.0
////        },
////        {
////            "login": "stevennathaniel",
////            "id": 685367,
////            "node_id": "MDQ6VXNlcjY4NTM2Nw==",
////            "avatar_url": "https://avatars.githubusercontent.com/u/685367?v=4",
////            "gravatar_id": "",
////            "url": "https://api.github.com/users/stevennathaniel",
////            "html_url": "https://github.com/stevennathaniel",
////            "followers_url": "https://api.github.com/users/stevennathaniel/followers",
////            "following_url": "https://api.github.com/users/stevennathaniel/following{/other_user}",
////            "gists_url": "https://api.github.com/users/stevennathaniel/gists{/gist_id}",
////            "starred_url": "https://api.github.com/users/stevennathaniel/starred{/owner}{/repo}",
////            "subscriptions_url": "https://api.github.com/users/stevennathaniel/subscriptions",
////            "organizations_url": "https://api.github.com/users/stevennathaniel/orgs",
////            "repos_url": "https://api.github.com/users/stevennathaniel/repos",
////            "events_url": "https://api.github.com/users/stevennathaniel/events{/privacy}",
////            "received_events_url": "https://api.github.com/users/stevennathaniel/received_events",
////            "type": "User",
////            "site_admin": false,
////            "score": 1.0
////        }
////    ]
//
//
//
//
//
//
//
//
//
