package asteroids;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

public class AsteroidMain
{

	public static void main(String[] args)
	{
		Save.load();

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				Game game = new Game(dim.width / 2, dim.height / 2, Game.FPS_60);
				game.start();
			}
		});

		Runtime.getRuntime().addShutdownHook(new Thread(() ->
		{
			Save.save();
			System.out.println("Exit normally");
		}));
	}
}