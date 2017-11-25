package com.zicronofandroid.avaliacaofinal1pedropita;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import static android.content.ContentValues.TAG;

public class professoresAdapter extends RecyclerView.Adapter<professoresAdapter.ProfessorViewHolder> {

    static Context context;
    List<professores.Professor> professores;

    professoresAdapter(List<professores.Professor> professores,Context context) {
        this.context= context;
        this.professores = professores;
    }

    @Override
    public ProfessorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ProfessorViewHolder pvh = new ProfessorViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProfessorViewHolder viewHolder, int i) {
        viewHolder.nomeView.setText(professores.get(i).nome);
        viewHolder.especialidadeView.setText(professores.get(i).especialidade);
        viewHolder.imageView.setImageResource(professores.get(i).imageId);
    }

    @Override
    public int getItemCount() {
        return professores.size();
    }

    public static class ProfessorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nomeView;
        TextView especialidadeView;
        ImageView imageView;

        ProfessorViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            nomeView = (TextView) itemView.findViewById(R.id.nomeView);
            especialidadeView = (TextView) itemView.findViewById(R.id.especialidadeView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context,professoresDetalhes.class);
            intent.putExtra("nome", nomeView.getText());
            intent.putExtra("especialidade", especialidadeView.getText());
            intent.putExtra("posicao",getPosition());
            context.startActivity(intent);
        }
    }
}