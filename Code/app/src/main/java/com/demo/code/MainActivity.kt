package com.demo.code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.demo.code.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView( binding.root)
        observeUiStates()
        //viewModel.uiLoaded()
    }

    private fun observeUiStates() {
        // Create a new coroutine from the lifecycleScope
        // since repeatOnLifecycle is a suspend function
        lifecycleScope.launch {
            // Suspend the coroutine until the lifecycle is DESTROYED.
            // repeatOnLifecycle launches the block in a new coroutine every time the
            // lifecycle is in the STARTED state (or above) and cancels it when it's STOPPED.
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                // Safely collect from locations when the lifecycle is STARTED
                // and stop collecting when the lifecycle is STOPPED
                viewModel.uiState.collect {
                    // Update UI elements
                    when (it) {
                        MainScreenStates.InitialUiState -> initialState()
                        MainScreenStates.UiLoadedState -> uiLoadedState()
                    }
                }
            }
            // At this point, the lifecycle is DESTROYED!
        }
    }

    /**
     * Screen is in loaded state
     */
    private fun uiLoadedState() {
        Snackbar.make(binding.root, "UI loaded State", Snackbar.LENGTH_SHORT).show();
    }

    /**
     * Screen is in initial state
     */
    private fun initialState() {
        Snackbar.make(binding.root, "Initial State", Snackbar.LENGTH_SHORT).show();
    }
}