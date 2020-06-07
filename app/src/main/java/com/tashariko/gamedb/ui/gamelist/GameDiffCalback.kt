package com.tashariko.gamedb.ui.gamelist

import androidx.recyclerview.widget.DiffUtil
import com.tashariko.gamedb.database.entity.GameDetail

class GameDiffCalback : DiffUtil.ItemCallback<GameDetail>() {
    override fun areItemsTheSame(oldItem: GameDetail, newItem: GameDetail): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: GameDetail, newItem: GameDetail): Boolean = oldItem == newItem

}