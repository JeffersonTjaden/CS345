package GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class HelpFile {
  private ResourceBundle messages;
  private String[] imagePaths;

  public HelpFile(ResourceBundle messages) {
      this.messages = messages;
      this.imagePaths = new String[30];
      for (int i = 0; i < this.imagePaths.length; i++) {
          this.imagePaths[i] = extractImage("Picture" + (i + 1) + ".png");
      }
  }

  public String generateTranslatedHtmlContent() {
      StringBuilder htmlBuilder = new StringBuilder();
      // Add the HTML header with the title
      htmlBuilder.append("<html><head><title>")
                 .append(messages.getString("fractal.title"))
                 .append("</title></head><body>");

      // Add the main title
      htmlBuilder.append("<h1>").append(messages.getString("fractal.title")).append("</h1>");

      // General/Navigation section
      htmlBuilder.append("<h2>").append(messages.getString("generalnav.title")).append("</h2>")
                 .append("<p>").append(messages.getString("launch.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[0]).append("' alt='Launch Icon'>")
                 .append("<p>").append(messages.getString("close.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[1]).append("' alt='Close Icon'>")
                 .append("<p>").append(messages.getString("close.menu.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[2]).append("' alt='Launch Icon'>");

      // Menu Bar Options section
      htmlBuilder.append("<h2>").append(messages.getString("menubaropt.title")).append("</h2>")
                 .append("<p>").append(messages.getString("print.file.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[3]).append("' alt='Launch Icon'>")
                 .append("<p>").append(messages.getString("mode.option.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[4]).append("' alt='Launch Icon'>")
                 .append("<img src='file:/").append(imagePaths[5]).append("' alt='Launch Icon'>")
                 .append("<img src='file:/").append(imagePaths[6]).append("' alt='Launch Icon'>")
                 .append("<img src='file:/").append(imagePaths[7]).append("' alt='Launch Icon'>")
                 .append("<p>").append(messages.getString("view.option.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[8]).append("' alt='Launch Icon'>")
                 .append("<img src='file:/").append(imagePaths[9]).append("' alt='Launch Icon'>")
                 .append("<p>").append(messages.getString("style.option.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[10]).append("' alt='Launch Icon'>")
                 .append("<img src='file:/").append(imagePaths[11]).append("' alt='Launch Icon'>")
                 .append("<img src='file:/").append(imagePaths[12]).append("' alt='Launch Icon'>")
                 .append("<p>").append(messages.getString("help.option.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[13]).append("' alt='Launch Icon'>")
                 .append("<img src='file:/").append(imagePaths[14]).append("' alt='Launch Icon'>")
                 .append("<img src='file:/").append(imagePaths[15]).append("' alt='Launch Icon'>");

      // Session History section
      htmlBuilder.append("<h2>").append(messages.getString("sesh.title")).append("</h2>")
                 .append("<p>").append(messages.getString("session.history.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[18]).append("' alt='Launch Icon'>");

      // Calculator Functions section
      htmlBuilder.append("<h2>").append(messages.getString("buttons.title")).append("</h2>")
                 .append("<img src='file:/").append(imagePaths[27]).append("' alt='Launch Icon'>")
                 .append("<p>").append(messages.getString("calculator.display.instruction")).append("</h2>")
                 .append("<p>").append(messages.getString("position.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("number.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("reset.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("clear.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("backspace.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("sign.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("operation.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("equals.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("mediant.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("integerPower.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("simplification.button.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("invert.button.instruction")).append("</p>");

      // Keyboard Usage section
      htmlBuilder.append("<h2>").append(messages.getString("keyboard.title")).append("</h2>")
                 .append("<p>").append(messages.getString("keyboard.usage.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("keyboard.operations.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("decimal.key.instruction")).append("</p>");

      // Language Support section
      htmlBuilder.append("<h2>").append(messages.getString("languageSupport.title")).append("</h2>")
                 .append("<p>").append(messages.getString("languageSupport.instruction")).append("</p>")
                 // Assuming imagePath17 is the path to the image showing the calculator in French
                 .append("<img src='file:/").append(imagePaths[16]).append("' alt='Language Support'>");

      // Recording section
      htmlBuilder.append("<h2>").append(messages.getString("recordingHtml.title")).append("</h2>")
                 .append("<p>").append(messages.getString("recording.instruction")).append("</p>")
                 // Assuming imagePath18 is the path to the image showing the recording controls
                 .append("<img src='file:/").append(imagePaths[17]).append("' alt='Recording Controls'>")
                 .append("<p>").append(messages.getString("playback.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("recording.save.example")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[20]).append("' alt='Recording Controls'>");

      // Intermediate Steps section
      htmlBuilder.append("<h2>").append(messages.getString("intermediateSteps.title")).append("</h2>")
                 .append("<p>").append(messages.getString("intermediateSteps.instruction")).append("</p>")
                 .append("<img src='file:/").append(imagePaths[21]).append("' alt='Recording Controls'>")
                 .append("<img src='file:/").append(imagePaths[22]).append("' alt='Recording Controls'>");

      // Customization section
      htmlBuilder.append("<h2>").append(messages.getString("customization.title")).append("</h2>")
                 .append("<p>").append(messages.getString("customization.instruction")).append("</p>")
                 .append("<p>").append(messages.getString("customization.examples")).append("</p>")
                 .append("<div><img src='file:/").append(imagePaths[23]).append("' alt='Customization Example 1'></div>")
                 .append("<div><img src='file:/").append(imagePaths[24]).append("' alt='Customization Example 2'></div>");

      // Comparing Fractions section
      htmlBuilder.append("<h2>").append(messages.getString("comparingFractions.title")).append("</h2>")
                 .append("<p>").append(messages.getString("comparingFractions.instruction")).append("</p>")
                 .append("<div><img src='file:/").append(imagePaths[25]).append("' alt='Customization Example 1'></div>")
                 .append("<div><img src='file:/").append(imagePaths[26]).append("' alt='Customization Example 2'></div>");

      // Close the HTML content
      htmlBuilder.append("</body></html>");
      return htmlBuilder.toString();
  }

  File createTempHtmlFile(String htmlContent) {
    File tempFile = null;
    try {
        // Create a temporary file
        tempFile = File.createTempFile("help", ".html");
        tempFile.deleteOnExit();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(htmlContent);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return tempFile;
  }

  private String extractImage(String imageName) {
    File tempDir = new File(System.getProperty("java.io.tmpdir"), "myapp-resources");
    File tempImageFile = new File(tempDir, imageName);

    try {
        if (!tempDir.exists() && !tempDir.mkdirs()) {
            return null;
        }

        // Get the URL of the image resource from the classpath
        java.net.URL imageUrl = getClass().getResource("/resources/" + imageName);
        if (imageUrl == null) {
            return null;
        }

        // Copy the image resource to the temporary directory
        try (InputStream in = imageUrl.openStream();
             FileOutputStream out = new FileOutputStream(tempImageFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }

    return tempImageFile.getAbsolutePath();
  }
}


