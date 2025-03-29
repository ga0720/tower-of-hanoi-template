
public class TowerSolver {
    private TowerModel model;

    public TowerSolver()
    {
        // Nothing to do here
    }

    public void solve(TowerModel model) {
        this.model = model;
        solve(model.getHeight(), 0, 2, 1);  // Move all disks from tower 0 to tower 2, using tower 1 as auxiliary
    }

    // Create an overloaded solve(...) method
    // This new method will be recursive (call itself)
    //
    // [ solve method here]
    //
    private void solve(int n, int source, int destination, int auxiliary) {
        if (n == 1) {
            model.move(source, destination);
            return;
        }
        
        solve(n - 1, source, auxiliary, destination); // Move n-1 disks to auxiliary
        model.move(source, destination);              // Move the nth (largest) disk to destination
        solve(n - 1, auxiliary, destination, source); // Move n-1 disks from auxiliary to destination
    }
}
