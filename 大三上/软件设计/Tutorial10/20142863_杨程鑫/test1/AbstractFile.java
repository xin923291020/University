package test1;

public abstract class AbstractFile
{
	public abstract void setName(String name);
	public abstract String getName();
	public abstract boolean getFlag();
	public abstract AbstractFile operation();
	public abstract void add(AbstractFile C);
	public abstract void remove(AbstractFile C);
	public abstract AbstractFile getChild(int i);
}