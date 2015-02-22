package nl.utwente.group10.ghcj;

import com.google.common.base.Splitter;
import nl.utwente.group10.haskell.expr.Binding;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Environment, that is, a collection of Bindings that lives in
 * a Haskell session, and has methods for querying that collection.
 */
public class GhciEnvironment {
    /** Our parent GhciSession instance. */
    private final GhciSession ghci;

    /**
     * Constructs a fresh GhciEnvironment.
     * @param ghci The parent GhciSession instance.
     */
    public GhciEnvironment(final GhciSession ghci) {
        this.ghci = ghci;
    }

    /**
     * Query the parent GHCI instance for a list of known functions.
     * @return all functions known to GHCI as Binding instances.
     * @throws GhciException when GHCI is not ready for our query.
     */
    public final List<Binding> getBindings() throws GhciException {
        String input = this.ghci.eval(":browse");
        List<Binding> out = new ArrayList<Binding>();

        for (String line : Splitter.on('\n').split(input)) {
            List<String> parts = Splitter.on(" :: ").splitToList(line);

            if (parts.size() == 2) {
                /* This could be a function declaration line. */
                String name = parts.get(0).trim();
                //String type = parts.get(1);

                out.add(new Binding(name, null));
            }
        }

        return out;
    }

    @Override
    public final String toString() {
        return "GhciEnvironment{" + "ghci=" + this.ghci + '}';
    }
}
