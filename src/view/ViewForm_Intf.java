package view;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Observer;

public interface ViewForm_Intf extends Observer {

	public final int MODE_SHOW = 0, MODE_MODIFY = 1, MODE_CREATE = 2;
	public final int SAVE_SUCCESS = 3, SAVE_INCOMPLETE = 4, SAVE_FAILURE = 5,
			DELETE_SUCCESS = 6, DELETE_FAILURE = 7;

	public void addConfirmationtionListener(ActionListener al);

	public void addDeleteListener(ActionListener al);

	public void addChangeModeListener(ItemListener il);

	public void changeMode(int mode);

	public void showFeedback(int feedback);

}
