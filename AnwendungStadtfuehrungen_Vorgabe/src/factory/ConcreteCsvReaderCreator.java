package factory;

public class ConcreteCsvReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() {
		return new ConcreteCsvReaderProduct();
	}

}
