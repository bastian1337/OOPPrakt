package factory;

public class ConcreteTxtReaderCreator extends ReaderCreator {

	@Override
	public ReaderProduct factoryMethod() {
		return new ConcreteTxtReaderProduct();
	}

}
