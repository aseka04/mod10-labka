package labka;

import java.util.ArrayList;
import java.util.List;

abstract class Component {
    String name;

    public Component(String name) {
        this.name = name;
    }

    abstract void display(int depth);

    void add(Component component) {
        throw new UnsupportedOperationException();
    }

    void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    public Component getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
class File extends Component {
    public File(String name) {
        super(name);
    }

    @Override
    void display(int depth) {
        System.out.println("-".repeat(depth) + " File: " + name);
    }
}

class Directory extends Component {
    private List<Component> children = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    void add(Component component) {
        children.add(component);
    }

    @Override
    void remove(Component component) {
        children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return children.get(index);
    }

    @Override
    void display(int depth) {
        System.out.println("-".repeat(depth) + " Directory: " + name);
        for (Component child : children) {
            child.display(depth + 2);
        }
    }
}


class Main2{
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");

        Directory subDir = new Directory("SubDirectory");
        File subFile1 = new File("SubFile1.txt");

        root.add(file1);
        root.add(file2);
        subDir.add(subFile1);
        root.add(subDir);

        root.display(1);

    }
}