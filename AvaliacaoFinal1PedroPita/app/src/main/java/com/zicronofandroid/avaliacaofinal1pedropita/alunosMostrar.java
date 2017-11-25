package com.zicronofandroid.avaliacaofinal1pedropita;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class alunosMostrar extends ListFragment {
    boolean dualFrame;
    int curPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(ArrayAdapter.createFromResource(getActivity(), R.array.nomeAluno, android.R.layout.simple_list_item_activated_1));
        View detailsFrame = getActivity().findViewById(R.id.details);
        dualFrame = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;
        if (savedInstanceState != null) {
            curPosition = savedInstanceState.getInt("curPosition", 0);
        }
        if (dualFrame) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(curPosition);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curPosition", curPosition);
        Log.i("curPosition", curPosition+"");
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        showDetails(position);
    }

    private void showDetails(int index) {
        curPosition = index;
        if (dualFrame) {
            getListView().setItemChecked(index, true);
            alunosDetalhes details = (alunosDetalhes)getFragmentManager().findFragmentById(R.id.details);
            if (details == null || details.getShownIndex() != index) {
                details = alunosDetalhes.newInstance(index);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }else{
            Intent intent = new Intent();
            intent.setClass(getActivity(), alunosVertical.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }
    }
}
