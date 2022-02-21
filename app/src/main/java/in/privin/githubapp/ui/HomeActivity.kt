package `in`.privin.githubapp.ui

import `in`.privin.githubapp.App
import `in`.privin.githubapp.R
import `in`.privin.githubapp.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class HomeActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "HomeActivity"
    }

    private val viewModel: HomeViewModel by lazy {
        HomeViewModel(App.getInstance().githubRepository)
    }

    lateinit var binding: ActivityMainBinding

    private val rvAdapter = GithubPrListAdapter(this,listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvRepo.text = applicationContext.getString(R.string.repo, "Test")
        observeData()
    }

    private fun observeData() {
        viewModel.prList.observe(this) {
            rvAdapter.updateData(it)
        }
    }

    private fun initRecyclerView(){
        binding.rvGithubPr.adapter = rvAdapter
        binding.rvGithubPr.layoutManager = LinearLayoutManager(this)
        binding.rvGithubPr.addItemDecoration(ListItemDecoration(10))
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()
        viewModel.getClosedPrList()
    }
}