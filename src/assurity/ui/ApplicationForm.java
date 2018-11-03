package assurity.ui;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import assurity.test.CriteriaTest;
import assurity.test.TestType;

/**
 *
 * @author Mohammad Ahmad
 * November, 2018
 *
 */
public class ApplicationForm extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	JTextField url_TextField, name_TextField, promotions_Name_TextField;
	JLabel runningTest_Label, assurity_image_label,
	url_Label, url_Pass_Label, url_Fail_Label,
	criteria_Label,
	name_Label, name_Pass_Label, name_Fail_Label,
	canRelist_Label, canRelist_Pass_Label, canRelist_Fail_Label,
	promotions_Label, promotions_Name_Label, promotions_Description_Label, promotions_Pass_Label, promotions_Fail_Label,
	results_Label, results_Output_Label;
	JTextArea promotions_Description_TextArea, results_Details_TextArea;
	JComboBox<String> canRelist_List;
	Button runTest_Button, reset_Button;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == runTest_Button) {
			new TestsSwingWorker().execute();

		} else if(e.getSource() == reset_Button) {
			reset();
		}

	}

	public ApplicationForm() {

		super("Assurity Sample API Test");
		assurity_image_label = new JLabel();
        assurity_image_label.setBounds(10, 0, 140, 43);
        assurity_image_label.setIcon(new ImageIcon(drawImage(Constants.Assuirty_LOGO)));

        runningTest_Label = new JLabel("Running the Test - Please Wait ... ");
        runningTest_Label.setBounds(170, 10, 250, 30);
        runningTest_Label.setFont(new Font("Tahoma", Font.ITALIC, 16));
        runningTest_Label.setForeground(new Color(158, 153, 43));
        runningTest_Label.setVisible(false);

        url_Pass_Label = new JLabel();
        url_Pass_Label.setBounds(20, 55, 20, 20);
        url_Pass_Label.setIcon(getPassIcon());
        url_Pass_Label.setVisible(false);

        url_Fail_Label = new JLabel();
        url_Fail_Label.setBounds(20, 55, 20, 20);
        url_Fail_Label.setIcon(getFailIcon());
        url_Fail_Label.setVisible(false);

		url_Label = new JLabel("Endpoint URL:");
	    url_Label.setBounds(50, 50, 100, 30);
	    url_Label.setFont(new Font(Font.DIALOG, Font.BOLD, 12));

	    url_TextField = new JTextField();
	    url_TextField.setBounds(150, 55, 350, 20);
	    url_TextField.setText(Constants.Endpoint_URL);

	    criteria_Label = new JLabel("Acceptance Criteria:");
	    criteria_Label.setBounds(50, 100, 180, 30);
	    criteria_Label.setFont(new Font(Font.DIALOG, Font.BOLD, 16));

	    name_Pass_Label = new JLabel();
        name_Pass_Label.setBounds(20, 135, 20, 20);
        name_Pass_Label.setIcon(getPassIcon());
        name_Pass_Label.setVisible(false);

        name_Fail_Label = new JLabel();
        name_Fail_Label.setBounds(20, 135, 20, 20);
        name_Fail_Label.setIcon(getFailIcon());
        name_Fail_Label.setVisible(false);

	    name_Label = new JLabel("[1] Assert \"Name\" equals to:");
	    name_Label.setBounds(50, 130, 200, 30);
	    name_Label.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));

	    name_TextField = new JTextField();
	    name_TextField.setBounds(290, 135, 140, 20);
	    name_TextField.setText(Constants.Expected_Name_Criteria);

	    canRelist_Pass_Label = new JLabel();
	    canRelist_Pass_Label.setBounds(20, 165, 20, 20);
	    canRelist_Pass_Label.setIcon(getPassIcon());
        canRelist_Pass_Label.setVisible(false);

	    canRelist_Fail_Label = new JLabel();
	    canRelist_Fail_Label.setBounds(20, 165, 20, 20);
	    canRelist_Fail_Label.setIcon(getFailIcon());
	    canRelist_Fail_Label.setVisible(false);

	    canRelist_Label = new JLabel("[2] Assert \"CanRelist\" value is:");
	    canRelist_Label.setBounds(50, 160, 240, 30);
	    canRelist_Label.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));

	    canRelist_List = new JComboBox<String>();
	    canRelist_List.setBounds(290, 165, 60, 20);
        canRelist_List.addItem("True");
        canRelist_List.addItem("False");
        canRelist_List.setSelectedItem("True");

        promotions_Pass_Label = new JLabel();
        promotions_Pass_Label.setBounds(20, 195, 20, 20);
        promotions_Pass_Label.setIcon(getPassIcon());
        promotions_Pass_Label.setVisible(false);

        promotions_Fail_Label = new JLabel();
        promotions_Fail_Label.setBounds(20, 195, 20, 20);
        promotions_Fail_Label.setIcon(getFailIcon());
        promotions_Fail_Label.setVisible(false);

        promotions_Label = new JLabel("[3] Assert \"Promotions\" element with:");
        promotions_Label.setBounds(50, 190, 260, 30);
        promotions_Label.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));

        promotions_Name_Label = new JLabel("[3.1] \"Name\" equals to:");
        promotions_Name_Label.setBounds(75, 215, 200, 30);
        promotions_Name_Label.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));

        promotions_Name_TextField = new JTextField();
        promotions_Name_TextField.setBounds(290, 220, 140, 20);
        promotions_Name_TextField.setText(Constants.Expected_Promotions_Name_Criteria);

        promotions_Description_Label = new JLabel("[3.2] \"Description\" containing the text:");
        promotions_Description_Label.setBounds(75, 235, 280, 30);
        promotions_Description_Label.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 12));

        promotions_Description_TextArea = new JTextArea();
        promotions_Description_TextArea.setBounds(290, 265, 140, 50);
        promotions_Description_TextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
        promotions_Description_TextArea.setLineWrap(true);
		promotions_Description_TextArea.setText(Constants.Expected_Promotions_Description_Content_Criteria);

		results_Label = new JLabel("Overall Result:");
		results_Label.setBounds(50, 340, 180, 30);
		results_Label.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		results_Label.setVisible(false);

		results_Output_Label = new JLabel(" Passed");
		results_Output_Label.setBounds(290, 345, 55, 25);
		results_Output_Label.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
		results_Output_Label.setOpaque(true);
		results_Output_Label.setVisible(false);

		results_Details_TextArea = new JTextArea();
		results_Details_TextArea.setBounds(70, 380, 355, 50);
		results_Details_TextArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(0, 0, 0, 0)));
		results_Details_TextArea.setEditable(false);
		results_Details_TextArea.setBackground(Color.GREEN);
		results_Details_TextArea.setLineWrap(true);
		results_Details_TextArea.setVisible(false);

		runTest_Button = new Button("Run Test");
		runTest_Button.setBounds(50, 450, 80, 20);
		runTest_Button.setFont(new Font("Arial", Font.BOLD, 12));
		runTest_Button.addActionListener(this);

		reset_Button = new Button("Reset");
		reset_Button.setBounds(150, 450, 50, 20);
		reset_Button.setFont(new Font("Arial", Font.BOLD, 12));
		reset_Button.addActionListener(this);


		setIconImage(drawImage(Constants.Assuirty_ICON));

		add(assurity_image_label);
		add(runningTest_Label);
		add(url_Pass_Label);
		add(url_Fail_Label);
		add(url_Label);
		add(url_TextField);
		add(criteria_Label);
		add(name_Label);
		add(name_TextField);
		add(name_Pass_Label);
		add(name_Fail_Label);
		add(canRelist_Pass_Label);
		add(canRelist_Fail_Label);
		add(canRelist_Label);
		add(canRelist_List);
		add(promotions_Label);
		add(promotions_Name_Label);
		add(promotions_Pass_Label);
		add(promotions_Fail_Label);
		add(promotions_Name_TextField);
		add(promotions_Description_Label);
		add(promotions_Description_TextArea);
		add(runTest_Button);
		add(reset_Button);
		add(results_Label);
		add(results_Output_Label);
		add(results_Details_TextArea);

		setLayout(null);
		setVisible(true);
		setSize(550, 520);
		setResizable(false);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		Line2D line1 = new Line2D.Float(0, 120, 550, 120);
		Line2D line2 = new Line2D.Float(0, 360, 550, 360);

		g2.draw(line1);
		g2.draw(line2);
	}

	private BufferedImage drawImage(String filepath) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(filepath));
		} catch (IOException e) {
			Logger.getLogger("Error in loading image").log(Level.WARNING, null, e);
		}
		return image;
	}

	private ImageIcon getPassIcon() {
		return new ImageIcon(drawImage(Constants.PASS_ICON));
	}

	private ImageIcon getFailIcon() {
		return new ImageIcon(drawImage(Constants.FAIL_ICON));
	}

	private void reset() {
		runningTest_Label.setVisible(false);
		url_Pass_Label.setVisible(false);
		url_Fail_Label.setVisible(false);

		name_Pass_Label.setVisible(false);
		name_Fail_Label.setVisible(false);
		canRelist_Pass_Label.setVisible(false);
		canRelist_Fail_Label.setVisible(false);
		promotions_Pass_Label.setVisible(false);
		promotions_Fail_Label.setVisible(false);
		results_Label.setVisible(false);
		results_Output_Label.setVisible(false);
		results_Details_TextArea.setVisible(false);
		setDefaultValues();
		repaint();
	}

	private void setDefaultValues() {
		if(url_TextField.getText().isEmpty()) {
			url_TextField.setText(Constants.Endpoint_URL);
		} else {
			Constants.Endpoint_URL = url_TextField.getText();
		}

		if(name_TextField.getText().isEmpty()) {
			name_TextField.setText(Constants.Expected_Name_Criteria);
		} else {
			Constants.Expected_Name_Criteria = name_TextField.getText();
		}

		Constants.Expected_CanRelist_Criteria = canRelist_List.getSelectedItem().equals("True") ? true: false;

		if(promotions_Name_TextField.getText().isEmpty()) {
			promotions_Name_TextField.setText(Constants.Expected_Promotions_Name_Criteria);
		} else {
			Constants.Expected_Promotions_Name_Criteria = promotions_Name_TextField.getText();
		}

		if(promotions_Description_TextArea.getText().isEmpty()) {
			promotions_Description_TextArea.setText(Constants.Expected_Promotions_Description_Content_Criteria);
		} else {
			Constants.Expected_Promotions_Description_Content_Criteria = promotions_Description_TextArea.getText();
		}
	}

	class TestsSwingWorker extends SwingWorker<Integer, String>
	{
		public Map<TestType, String> Failure_Results_Map;

		public TestsSwingWorker() {
			Failure_Results_Map = new HashMap<TestType, String>();
		}

	    @Override
	    protected Integer doInBackground() throws Exception
	    {
	    	reset();
	    	runTest_Button.setEnabled(false);
			reset_Button.setEnabled(false);

	        runningTest_Label.setVisible(true);
	        CriteriaTest test = new CriteriaTest();
			try {
				CriteriaTest.setupHttpConnection();
			} catch (AssertionError e) {
				Failure_Results_Map.put(TestType.RESPONSE_CODE, e.getMessage());
				return null;
			}

			try {
				test.responseStatusTest();
			} catch (AssertionError e) {
				Failure_Results_Map.put(TestType.RESPONSE_CODE, e.getMessage());
				return null;
			}

			try {
				test.responseContentTypeTest();
			} catch (AssertionError e) {
				Failure_Results_Map.put(TestType.RESPONSE_CONTENT_TYPE, e.getMessage());
				return null;
			}

			try {
				test.responseNameCriteriaTest();
			} catch (AssertionError e) {
				Failure_Results_Map.put(TestType.RESPONSE_NAME_CRITERIA, e.getMessage());
				return null;
			}

			try {
				test.responseCanRelistCriteriaTest();
			} catch (AssertionError e) {
				Failure_Results_Map.put(TestType.RESPONSE_CANRELIST_CRITERIA, e.getMessage());
				return null;
			}

			try {
				test.responsePromotionsCriteriaTest();
			} catch (AssertionError e) {
				Failure_Results_Map.put(TestType.RESPONSE_PROMOTIONS_CRITERIA, e.getMessage());
				return null;
			}
	        return null;
	    }


	    @Override
	    protected void done()
	    {
	    	if (!Failure_Results_Map.isEmpty()) {
				results_Output_Label.setText(" Failed");
				results_Output_Label.setBackground(Color.RED);
				results_Details_TextArea.setBackground(Color.RED);
				if (Failure_Results_Map.containsKey(TestType.RESPONSE_CODE)) {
					url_Pass_Label.setVisible(false);
					url_Fail_Label.setVisible(true);
					results_Details_TextArea.setText(" Error in "+ TestType.RESPONSE_CODE.getTestType() + ":\n "
							+ Failure_Results_Map.get(TestType.RESPONSE_CODE));

				} else if (Failure_Results_Map.containsKey(TestType.RESPONSE_CONTENT_TYPE)) {
					url_Pass_Label.setVisible(false);
					url_Fail_Label.setVisible(true);
					results_Details_TextArea.setText(" Error in "+ TestType.RESPONSE_CONTENT_TYPE.getTestType() + ":\n "
							+ Failure_Results_Map.get(TestType.RESPONSE_CONTENT_TYPE));
				} else {
					url_Pass_Label.setVisible(true);
					url_Fail_Label.setVisible(false);
					if (Failure_Results_Map.containsKey(TestType.RESPONSE_NAME_CRITERIA)) {
						name_Pass_Label.setVisible(false);
						name_Fail_Label.setVisible(true);
						results_Details_TextArea.setText(" Error in "+ TestType.RESPONSE_NAME_CRITERIA.getTestType() + ":\n "
								+ Failure_Results_Map.get(TestType.RESPONSE_NAME_CRITERIA));

					} else if (Failure_Results_Map.containsKey(TestType.RESPONSE_CANRELIST_CRITERIA)) {
						name_Pass_Label.setVisible(true);
						name_Fail_Label.setVisible(false);
						canRelist_Fail_Label.setVisible(true);
						canRelist_Pass_Label.setVisible(false);
						results_Details_TextArea.setText(" Error in "+ TestType.RESPONSE_CANRELIST_CRITERIA.getTestType() + ":\n "
								+ Failure_Results_Map.get(TestType.RESPONSE_CANRELIST_CRITERIA));

					} else if (Failure_Results_Map.containsKey(TestType.RESPONSE_PROMOTIONS_CRITERIA)) {
						name_Pass_Label.setVisible(true);
						name_Fail_Label.setVisible(false);
						canRelist_Fail_Label.setVisible(false);
						canRelist_Pass_Label.setVisible(true);
						promotions_Fail_Label.setVisible(true);
						promotions_Pass_Label.setVisible(false);
						results_Details_TextArea.setText(Failure_Results_Map.get(TestType.RESPONSE_PROMOTIONS_CRITERIA));
					}
				}

			} else {

				url_Pass_Label.setVisible(true);
				url_Fail_Label.setVisible(false);
				name_Pass_Label.setVisible(true);
				name_Fail_Label.setVisible(false);
				canRelist_Fail_Label.setVisible(false);
				canRelist_Pass_Label.setVisible(true);
				promotions_Fail_Label.setVisible(false);
				promotions_Pass_Label.setVisible(true);
				results_Output_Label.setBackground(Color.GREEN);
				results_Details_TextArea.setBackground(Color.GREEN);
				results_Output_Label.setText(" Passed");
				results_Details_TextArea.setText("Congratulations. Your test has passed!");
			}

	    	results_Label.setVisible(true);
			results_Output_Label.setVisible(true);
			results_Details_TextArea.setVisible(true);
	    	runningTest_Label.setVisible(false);

	    	runTest_Button.setEnabled(true);
	 		reset_Button.setEnabled(true);
	 		repaint();
	    }
	};
}
