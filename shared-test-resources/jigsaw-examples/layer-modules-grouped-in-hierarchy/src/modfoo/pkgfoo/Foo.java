package pkgfoo;

import pkgcommon.IdGen;
import pkgcommon.LayerPrinter;

public class Foo {
	private String id;

	public Foo() throws Exception {
		// we are using functionality from modcommon here
		id = IdGen.createID();
		LayerPrinter.printRuntimeInfos(this.getClass().getModule().getLayer(), this);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + ", id=" + id + ", using automatic module version "
				+ new pkgversion.Version1().toString(); // we are using functionality from modauto1 here
	}
}