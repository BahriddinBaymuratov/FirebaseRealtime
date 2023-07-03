package com.example.firebaserealtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebaserealtime.databinding.ActivityUsersBinding
import com.example.firebaserealtime.model.User
import com.example.firebaserealtime.model.UserAdapter
import com.google.firebase.database.*

class UsersActivity : AppCompatActivity() {
    private val binding by lazy { ActivityUsersBinding.inflate(layoutInflater) }
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    private lateinit var userAdapter: UserAdapter
    private lateinit var list: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        reference = firebaseDatabase.getReference("users")
        list = ArrayList()
        userAdapter = UserAdapter(list)

        binding.rv.adapter = userAdapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                val children = snapshot.children
                children.forEach {
                    val value = it.getValue(User::class.java)
                    Log.d("@@@", "onDataChange: $value")
                    if (value != null) {
                        list.add(value)
                    }
                }
                userAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

}