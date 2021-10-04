package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityPhoneBookWithRecyclerViewBinding

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityPhoneBookWithRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneBookWithRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 방법1(변수를 만들어 준 경우)
        val phoneBook = createFakePhoneBook(fakeNumber = 30)
        val phoneBookRecyclerAdapter = PhoneBookRecyclerAdapter(
            phonebookList = phoneBook,
            inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
            activity = this
        )
        binding.phonebookRecyclerView.adapter = phoneBookRecyclerAdapter
        binding.phonebookRecyclerView.layoutManager =
            LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)

        // 방법2(변수를 만들지 않고 코드를 줄인 경우)
//        with(binding.phonebookRecyclerView){
//            this.adapter = PhoneBookRecyclerAdapter(
//                phonebookList = createFakePhoneBook(fakeNumber = 30),
//                inflater = LayoutInflater.from(this@PhoneBookWithRecyclerViewActivity),
//                activity = this@PhoneBookWithRecyclerViewActivity
//            )
//            this.layoutManager = LinearLayoutManager(this@PhoneBookWithRecyclerViewActivity)
//        }

    }

    fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {
        for (i in 0 until fakeNumber) {
            phoneBook.addPerson(Person(name = "" + i + "번째 사람", number = "" + i + "번째 사람의 전화 번호"))
        }
        return phoneBook
    }
}

class PhoneBookRecyclerAdapter(
    val phonebookList: PhoneBook,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName: TextView

        init {
            personName = itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener {
                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                intent.putExtra("name", phonebookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phonebookList.personList.get(adapterPosition).number)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebook_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phonebookList.personList.get(position).name)
    }

    override fun getItemCount(): Int {
        return phonebookList.personList.size
    }
}