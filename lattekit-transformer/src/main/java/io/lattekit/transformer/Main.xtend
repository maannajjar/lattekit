package io.lattekit.transformer

class Main {

	def static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java Main SRC_DIR OUT_DIR");
			return
		}
		new LatteTransformer().transform(args.get(0),args.get(1),".css")

	}
}
