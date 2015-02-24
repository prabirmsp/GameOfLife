package edu.grinnell.pradhanp.gameoflife;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by prabir on 2/21/15.
 */
public class BoardAdapter extends BaseAdapter {

    private Context context;
    private boolean[] gameBoard;
    private int cellHeight;

    public BoardAdapter(Context context, boolean[] board, int cellHeight) {
        this.context = context;
        this.gameBoard = board;
        this.cellHeight = cellHeight;
    }

	public View getView(int position, View convertView, ViewGroup parent) {


		View cellView;

		if (convertView == null) {

			cellView = new View(context);

            boolean cell = gameBoard[position];
            if (cell)
                cellView.setBackground(context.getResources().getDrawable(R.drawable.live_cell));
            else
                cellView.setBackground(context.getResources().getDrawable(R.drawable.dead_cell));

            cellView.setMinimumHeight(cellHeight);

		} else {
			cellView = (View) convertView;
		}

		return cellView;
	}


    @Override
	public int getCount() {
		return gameBoard.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
}
