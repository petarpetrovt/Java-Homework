package com.DeckOfCards;

import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class DeckOfCards {
	public static void main(String[] args) {
		try {
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("Deck.pdf"));
			document.open();

			PdfContentByte canvas = writer.getDirectContent();
			BaseFont baseFont = BaseFont.createFont("DeckOfCards_lib/times.ttf",
					BaseFont.IDENTITY_H, true);

			canvas.setTextRenderingMode(PdfContentByte.TEXT_RENDER_MODE_FILL_STROKE);
			canvas.setLineWidth(1.5f);

			char[] chars = new char[] { '♠', '♥', '♣', '♦' };
			String[] cards = new String[] { "2", "3", "4", "5", "6", "7", "8",
					"9", "10", "J", "Q", "K", "A" };
			int width = 50;
			int height = 70;
			int margin = 4;
			int x = 4;
			int y = 4;
			int row = 0;
			int count = 0;
			int color = 0;
			int card = 0;
			boolean red = true;

			for (int i = 0; i < 52; i++) {
				if (count == 11) {
					row++;
					count = 0;
				}

				if (i % 13 == 0 && i != 0) {
					color++;
					if (red) {
						canvas.setRGBColorStroke(0xFF, 0x00, 0x00);
						canvas.setRGBColorFill(0xFF, 0x00, 0x00);
						red = false;
					} else {
						canvas.setRGBColorStroke(0x00, 0x00, 0x00);
						canvas.setRGBColorFill(0x00, 0x00, 0x00);
						red = true;
					}

					card = 0;
				}

				x = count * width + margin;
				y = row * height + margin;
				Rectangle rect = new Rectangle(x, y, x + width - margin, y
						+ height - margin);
				rect.setBorder(Rectangle.BOX);
				rect.setBorderWidth(1);
				canvas.rectangle(rect);

				canvas.beginText();
				canvas.setFontAndSize(baseFont, 18);
				canvas.showTextAligned(Element.ALIGN_CENTER, cards[card] + " "
						+ chars[color], x + width / 2, y + height / 2, 0);
				canvas.endText();

				count++;
				card++;
			}

			document.close();

			//Process p = Runtime.getRuntime().exec(
			//		"rundll32 url.dll,FileProtocolHandler Deck.pdf");
			//p.waitFor();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
