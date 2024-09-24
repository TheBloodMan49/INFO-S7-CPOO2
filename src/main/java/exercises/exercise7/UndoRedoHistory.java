package exercises.exercise7;

import java.util.LinkedList;
import java.util.Optional;

public class UndoRedoHistory  implements Undoable {

	private int sizeMax;
	LinkedList<Undoable> undos;
	LinkedList<Undoable> redos;

	public UndoRedoHistory() {
		this(10);
	}

	public UndoRedoHistory(final int sizeMax) {
		this.sizeMax = sizeMax;
		undos = new LinkedList<>();
		redos = new LinkedList<>();
	}

	public void add(final Undoable undoable) {
		if(undoable == null) {
			return;
		}
		if(undos.size() == sizeMax) {
			undos.removeFirst();
		}
		undos.add(undoable);
		redos.clear();
	}

	public void undo() {
		if(!undos.isEmpty()) {
			final Undoable undoable = undos.removeLast();
			undoable.undo();
			redos.add(undoable);
		}
	}

	public void redo() {
		if(!redos.isEmpty()) {
			final Undoable undoable = redos.removeLast();
			undoable.redo();
			undos.add(undoable);
		}
	}

	public int getNbUndoables() {
		return undos.size();
	}

	public int getNbRedoables() {
		return redos.size();
	}

	public void setSizeMax(final int size) {
		sizeMax = size;
	}

	public Optional<Undoable> getLastUndo() {
		return undos.isEmpty() ? Optional.empty() : Optional.of(undos.getLast());
	}
}
