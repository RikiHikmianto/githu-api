package co.id.rikihikmianto.usergithub.detail

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import co.id.rikihikmianto.usergithub.R
import co.id.rikihikmianto.usergithub.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.tabs.TabLayoutMediator


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var detailViewModel: DetailViewModel

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        val bundle = Bundle()
        bundle.putString(EXTRA_USERNAME, username)

        showLoading(true)
        detailViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(DetailViewModel::class.java)

        detailViewModel.setDetailUser(username)
        detailViewModel.getDetailUser().observe(this, {
            if (it != null) {
                Glide.with(this).load(it.avatar)
                    .transition(DrawableTransitionOptions.withCrossFade()).centerCrop()
                    .into(binding.ivAvatar)
                binding.tvName.text = it.name
                binding.tvUsername.text = it.username
                binding.tvRepo.text = "${it.repo} Repositories"
                binding.tvFollowers.text = "${it.followers} Followers"
                binding.tvFollowing.text = "${it.following} Following"
                showLoading(false)
            }
        })

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle, bundle)
        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabs, binding.viewPager){tab, position ->
            when(position){
                0 -> tab.text = "Followers"
                1 -> tab.text = "Following"
            }
        }.attach()
    }

    private fun showLoading(b: Boolean) {
        if (b) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}