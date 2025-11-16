package Batman;

import java.awt.Color;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.awt.BorderLayout;



public class pnlMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlPlay;
    private JLabel lblLevelInfo;
    private JLabel lblRiddle;
    private JTextField txtRiddleAnswer;
    private JSeparator separator;
    private JLabel lblResult;
    private JLabel lblResultPic;
    private JButton btnExit;
    
    private int intRiddleNum = 1;
    private int intRiddleTry = 1;
    private static final int intNumOfTryAllow = 3;
    private String strLevelInfo = "Level 1 - Riddle";
    private Map<Integer, String> dictRiddlesData;
    private JButton btnPlayAgain;
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pnlMain frame = new pnlMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pnlMain() {
				
		riddlerGame gameIntroObj = new riddlerGame();

		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/BatmanIcon.png")));
		setTitle("BatmanVsRiddler");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 660);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMainPic = new JLabel("");
		lblMainPic.setVerticalAlignment(SwingConstants.TOP);
		Image img = new ImageIcon(this.getClass().getResource("/BatmanFly444.png")).getImage();
		lblMainPic.setIcon(new ImageIcon(img));
		lblMainPic.setBounds(0, 0, 786, 200);
		contentPane.add(lblMainPic);
		
		JLabel lblIntro = new JLabel("");
		lblIntro.setVerticalAlignment(SwingConstants.TOP);
		lblIntro.setBounds(10, 211, 766, 62);
		lblIntro.setFont(new Font("Calibri", Font.BOLD, 14));
		lblIntro.setText(gameIntroObj.intro());
		contentPane.add(lblIntro);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				pnlPlay.setVisible(true);
				lblLevelInfo.setText(strLevelInfo);
				dictRiddlesData = gameIntroObj.getRiddlesData();
				lblRiddle.setText(dictRiddlesData.get(1));
			}
		});
		
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPlay.setBounds(10, 279, 766, 39);
		contentPane.add(btnPlay);
		
		Border blackline = BorderFactory.createLineBorder(Color.black, 3);
		pnlPlay = new JPanel();
		pnlPlay.setBounds(10, 329, 766, 273);
		pnlPlay.setBorder(blackline);
		pnlPlay.setVisible(false);
		contentPane.add(pnlPlay);
		pnlPlay.setLayout(null);
		
		lblLevelInfo = new JLabel("lblLevelInfo");
		lblLevelInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLevelInfo.setBounds(10, 11, 334, 14);
		pnlPlay.add(lblLevelInfo);
		
		lblRiddle = new JLabel("lblRiddle");
		lblRiddle.setVerticalAlignment(SwingConstants.TOP);
		lblRiddle.setBounds(10, 47, 351, 44);
		lblRiddle.setFont(new Font("Calibri", Font.BOLD, 14));
		pnlPlay.add(lblRiddle);
		
		txtRiddleAnswer = new JTextField();
		txtRiddleAnswer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				lblResult.setText("");
				lblResultPic.setIcon(null);
				
				 if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					 
					 if(txtRiddleAnswer.getText().length() > 0)
					 {
						 runGame(txtRiddleAnswer.getText());
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, 
		                            "Provide riddle answer", 
		                            "Batman Vs Riddler", 
		                            JOptionPane.ERROR_MESSAGE);
					 }
					
				 }
			}
		});

		txtRiddleAnswer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRiddleAnswer.setBounds(157, 102, 204, 28);
		pnlPlay.add(txtRiddleAnswer);
		txtRiddleAnswer.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(10, 36, 746, 2);
		pnlPlay.add(separator);
		
		lblResult = new JLabel("");
		lblResult.setFont(new Font("Calibri", Font.BOLD, 14));
		lblResult.setVerticalAlignment(SwingConstants.TOP);
		lblResult.setBounds(10, 141, 311, 28);
		pnlPlay.add(lblResult);
		
		lblResultPic = new JLabel("");
		lblResultPic.setBounds(409, 50, 287, 195);
		pnlPlay.add(lblResultPic);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(10, 228, 121, 28);
		pnlPlay.add(btnExit);
		
		JButton btnSubmit = new JButton("Crack IT");
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lblResult.setText("");
				lblResultPic.setIcon(null);
				
				if(txtRiddleAnswer.getText().length() > 0)
				{
					runGame(txtRiddleAnswer.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null, 
                            "Provide riddle answer", 
                            "Batman Vs Riddler", 
                            JOptionPane.ERROR_MESSAGE);
				}
				    
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(10, 102, 121, 28);
		pnlPlay.add(btnSubmit);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				lblResult.setText("");
       		    lblResultPic.setIcon(null);
       		    
				if(txtRiddleAnswer.getText().length() > 0)
				{
					runGame(txtRiddleAnswer.getText());
				}
				
				btnPlayAgain.setVisible(false);
			}
		});
		btnPlayAgain.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPlayAgain.setBounds(157, 228, 121, 28);
		btnPlayAgain.setVisible(false);
		pnlPlay.add(btnPlayAgain);
		
	}
	
	private void runGame(String riddleAnswer)
	{
		
		riddlerGame gameObj = new riddlerGame();
		
		  Map<Integer, String> dictRiddleData;

		  dictRiddleData = gameObj.levelOne(riddleAnswer);
          
		  switch (intRiddleNum) {
          case 1:  {
        	  dictRiddleData = gameObj.levelOne(riddleAnswer);
        	  if(dictRiddleData.containsKey(1))
    		  {
        		  intRiddleNum++;
        		  txtRiddleAnswer.setText("");
        		  lblLevelInfo.setText("Level " + intRiddleNum + " - Riddle");
        		  lblRiddle.setText(dictRiddlesData.get(intRiddleNum));
    		  }
    		  else
    		  {
    			  lblResult.setText("Incorrect answer. Attempts remaining: " + (intNumOfTryAllow - intRiddleTry));
    			  intRiddleTry++;
    			  
    			  if(intRiddleTry > 3) 
    			  {
    				  Reset();
          			  lblResult.setText("You lose");
        			  Image ImgYouLose = new ImageIcon(this.getClass().getResource("/Batman.jpeg")).getImage();
               		  lblResultPic.setIcon(new ImageIcon(ImgYouLose));
    		      }
    		  }
        	  break;
          }
          case 2:  {
        	  System.out.println("The intRiddleTry Value is out 2: " + riddleAnswer);
          	  dictRiddleData = gameObj.levelTwo(riddleAnswer);
        	  if(dictRiddleData.containsKey(2))
    		  {
        		  intRiddleNum++;
        		  txtRiddleAnswer.setText("");
        		  lblLevelInfo.setText("Level " + intRiddleNum + " - Riddle");
        		  lblRiddle.setText(dictRiddlesData.get(intRiddleNum));
    		  }
    		  else
    		  {
    			  lblResult.setText("Incorrect answer. Attempts remaining: " + (intNumOfTryAllow - intRiddleTry));
    			  intRiddleTry++;
    			  
    			  if(intRiddleTry > 3) 
    			  {
    				  Reset();
        			  lblResult.setText("You lose");
        			  Image ImgYouLose = new ImageIcon(this.getClass().getResource("/Batman.jpeg")).getImage();
               		  lblResultPic.setIcon(new ImageIcon(ImgYouLose));
    		      }
    		  }    	  
        	  break;
          }
          case 3:  {
          	  dictRiddleData = gameObj.levelThree(riddleAnswer);
        	  if(dictRiddleData.containsKey(3))
    		  {
        		  intRiddleNum = 1;
        		  intRiddleTry = 1;
        		  txtRiddleAnswer.setText("");
        		  lblResult.setText("You Won!!");
        		  Image ImgYouWon = new ImageIcon(this.getClass().getResource("/RiddlerWon.jpeg")).getImage();
        		  lblResultPic.setIcon(new ImageIcon(ImgYouWon));
        		  lblLevelInfo.setText("Level " + intRiddleNum + " - Riddle");
        		  lblRiddle.setText(dictRiddlesData.get(intRiddleNum));
           		  btnPlayAgain.setVisible(true);
           		  
    		  }
    		  else
    		  {
    			  lblResult.setText("Incorrect answer. Attempts remaining: " + (intNumOfTryAllow - intRiddleTry));
    			  intRiddleTry++;
    			  
    			  if(intRiddleTry > 3) 
    			  {
    				  Reset();
        			  lblResult.setText("You lose");
        			  Image ImgYouLose = new ImageIcon(this.getClass().getResource("/Batman.jpeg")).getImage();
               		  lblResultPic.setIcon(new ImageIcon(ImgYouLose));
    		      }
    		  }      	  
        	  break;
          }

      }

	} //END of runGame()
	
	private void Reset()
	{
		intRiddleTry = 1;
		txtRiddleAnswer.setText("");
		lblResult.setText("");
		
		if(intRiddleNum == 2)
		{
			intRiddleNum = 1;
		}
		else if(intRiddleNum == 3)
		{
			intRiddleNum = 2;
		}
		
		txtRiddleAnswer.setText("");
		lblLevelInfo.setText("Level " + intRiddleNum + " - Riddle");
		lblRiddle.setText(dictRiddlesData.get(intRiddleNum));
	}
}
