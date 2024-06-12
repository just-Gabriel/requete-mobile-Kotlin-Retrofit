package fr.maloof.requestonapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExperienceAdapter(private val experiences: List<Experience>) :
    RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        return ExperienceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        val experience = experiences[position]
        holder.tvAgreabilite.text = "Agreabilite: ${experience.agreabilite}"
        holder.tvIntensite.text = "Intensite: ${experience.intensite}"
        holder.tvImpression.text = "Impression: ${experience.impression}"
        holder.tvUser.text = "User: ${experience.user}"
        holder.tvTelephone.text = "Telephone: ${experience.telephone}"
        holder.tvVibration.text = "Vibration: ${experience.vibration}"
    }

    override fun getItemCount(): Int {
        return experiences.size
    }

    class ExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAgreabilite: TextView = itemView.findViewById(R.id.tvAgreabilite)
        val tvIntensite: TextView = itemView.findViewById(R.id.tvIntensite)
        val tvImpression: TextView = itemView.findViewById(R.id.tvImpression)
        val tvUser: TextView = itemView.findViewById(R.id.tvUser)
        val tvTelephone: TextView = itemView.findViewById(R.id.tvTelephone)
        val tvVibration: TextView = itemView.findViewById(R.id.tvVibration)
    }
}
