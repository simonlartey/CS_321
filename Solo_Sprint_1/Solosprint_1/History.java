import java.util.Stack;

public class History {
    private final Stack<EditorState> undoStack = new Stack<>();
    private final Stack<EditorState> redoStack = new Stack<>();

    public void saveState(EditorState state) {
        undoStack.push(state);
        redoStack.clear(); // once you save a new action, redo history is reset
    }

    public EditorState undo() {
        if (!undoStack.isEmpty()) {
            EditorState state = undoStack.pop();
            redoStack.push(state);
            return !undoStack.isEmpty() ? undoStack.peek() : null;
        }
        return null;
    }

    public EditorState redo() {
        if (!redoStack.isEmpty()) {
            EditorState state = redoStack.pop();
            undoStack.push(state);
            return state;
        }
        return null;
    }
}
