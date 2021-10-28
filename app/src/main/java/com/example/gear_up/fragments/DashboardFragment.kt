package com.example.gear_up.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gear_up.*
import com.example.gear_up.R
import com.example.gear_up.databinding.FragmentDashboardBinding
import com.google.firebase.firestore.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    // for recyclerview
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    // for view binding
    private lateinit var binding: FragmentDashboardBinding

    // For firestore db
    private lateinit var db : FirebaseFirestore

    // for subject array list
    private lateinit var subjectArraylist : ArrayList<Student_Subject>

    // Myadapter
    private lateinit var myAdapter: Student_Subject_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {

        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // we can't use findViewById() in fragments. Hence we are using view binding
        //val recyclerView = binding.recyclerView

        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


        // for recyclerview
        //layoutManager = LinearLayoutManager(context)
//        binding.recyclerView.layoutManager = LinearLayoutManager(context)
//        binding.recyclerView. = layoutManager
//        adapter = RecyclerAdapter()
//        binding.recyclerView.adapter = adapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // for recyclerview
        //layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        //binding.recyclerView. = layoutManager

        // Below 2 lines are for static items
//        adapter = RecyclerAdapter()
//        binding.recyclerView.adapter = adapter

        binding.recyclerView.setHasFixedSize(true)
        subjectArraylist = arrayListOf()
        myAdapter = Student_Subject_Adapter(subjectArraylist) // 2nd paramter added in the process of intent to recyclerview
        binding.recyclerView.adapter = myAdapter

        // for item click event in recyclerview
        myAdapter.setOnItemClickListener(object : Student_Subject_Adapter.onItemClickListener{
            override fun onItemClcik(positiion: Int) {
                // toast to find position of item in recyclerview
//                Toast.makeText(
//                    activity,
//                    "You clicked on item no: $positiion",
//                    Toast.LENGTH_SHORT
//                ).show()
                val intent = Intent(activity,subject_Homepage::class.java)
                intent.putExtra("subjectName",subjectArraylist[positiion].C_Name)
                intent.putExtra("subjectCode",subjectArraylist[positiion].C_Code)
                startActivity(intent)
            }

        })





        EventChangeListerner() // for dynamic recyclerview

    }

    private fun EventChangeListerner() {
        db = FirebaseFirestore.getInstance()
        // if we don't want to make it in ascending order then simply remove .orderBy()
        // In the argument of orderBy() the field name should be pass amd it must be same as Firebase Field
        db.collection("faculty").orderBy("C_Name",Query.Direction.ASCENDING).
                addSnapshotListener(object : EventListener<QuerySnapshot>{
                    override fun onEvent(
                        value: QuerySnapshot?,
                        error: FirebaseFirestoreException?
                    ) {

                        if(error != null){
                            Log.e("Firestore Error",error.message.toString())
                            return
                        }
                        // if no error then loop through all the documents
                        for (dc: DocumentChange in value?.documentChanges!!){
                            if(dc.type == DocumentChange.Type.ADDED){
                                subjectArraylist.add(dc.document.toObject(Student_Subject:: class.java))
                                // converted document data to the Student_Subject class
                            }
                        }

                        // After we loop through all the document then
                        myAdapter.notifyDataSetChanged()

                    }

                })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDashboardBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}