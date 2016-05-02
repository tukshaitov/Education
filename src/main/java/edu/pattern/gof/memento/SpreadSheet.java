package edu.pattern.gof.memento;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eldar on 11/8/2015.
 */ /* Originator */
public class SpreadSheet {

    private Cell[][] cells = cells = new Cell[5][10];
    private Memento memento = new Memento();
    private GraphicContext context;

    public SpreadSheet(GraphicContext context) {
        this.context = context;
    }

    public SpreadSheet(GraphicContext context, int rows, int columns) {
        this.context = context;
        if (rows > 0 && columns > 0)
            cells = new Cell[rows][columns];
    }

    public Cell getCell(int row, int column) {
        if (row < cells.length && column < cells.length) {
            Cell cell = cells[row][column];
            if (cell == null)
                cell = new Cell(row, column);
            cells[row][column] = cell;
            return cell;
        }
        return null;
    }

    public Memento getIncrementalMemento() {
        Memento memento = this.memento;
        this.memento = new Memento();
        return memento;
    }

    public RestoreStatus restoreFromMemento(Memento memento) {
        RestoreStatus restoreStatus = RestoreStatus.CONTEXT;
        if (this.memento.cellMap.size() != 0)
            memento = this.memento;
        else if (memento != null)
            restoreStatus = RestoreStatus.MEMENTO;
        else
            restoreStatus = RestoreStatus.NONE;

        if (restoreStatus != RestoreStatus.NONE) {
            for (Memento.Key key : memento.cellMap.keySet()) {
                CellField cellField = memento.cellMap.get(key);

                switch (key.cellFieldType) {
                    case BGCOLOR:
                        cells[key.row][key.column].setBackgroundColor(((BackgroundColorCellField) cellField).backgroundColor);
                        break;
                    case COLOR:
                        cells[key.row][key.column].setColor(((ColorCellField) cellField).color);
                        break;
                    case FONT:
                        cells[key.row][key.column].setFont(((FontCellField) cellField).font);
                        break;
                    case FONT_STYLE:
                        cells[key.row][key.column].setFontStyle(((FontStyleCellField) cellField).fontStyle);
                        break;
                    case VALUE:
                        cells[key.row][key.column].setValue(((ValueCellField) cellField).value);
                        break;
                }
            }
        }
        this.memento = new Memento();
        context.draw("");
        return restoreStatus;
    }

    enum CellFieldType {BGCOLOR, COLOR, FONT, FONT_STYLE, VALUE, IS_NEW}
    private interface CellField {
    }

    private static class BackgroundColorCellField implements CellField {
        private Color backgroundColor = Color.WHITE;

        public BackgroundColorCellField(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
    }

    private static class ColorCellField implements CellField {
        private Color color = Color.BLACK;

        public ColorCellField(Color color) {
            this.color = color;
        }
    }

    private static class FontCellField implements CellField {
        private Font font = Font.LUCIDA;

        public FontCellField(Font font) {
            this.font = font;
        }
    }

    private static class FontStyleCellField implements CellField {
        private FontStyle fontStyle = FontStyle.NONE;

        public FontStyleCellField(FontStyle fontStyle) {
            this.fontStyle = fontStyle;
        }
    }

    private static class ValueCellField implements CellField {
        private String value = "";

        public ValueCellField(String value) {
            this.value = value;
        }
    }

    public static class Memento {
        private Map<Key, CellField> cellMap = new HashMap<>();

        private void set(Key key, CellField cellField) {
            if (!cellMap.containsKey(key))
                cellMap.put(key, cellField);
        }

        private static class Key {
            private int row;
            private int column;
            private CellFieldType cellFieldType;

            public Key(int row, int column, CellFieldType cellFieldType) {
                this.row = row;
                this.column = column;
                this.cellFieldType = cellFieldType;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Key key = (Key) o;

                if (row != key.row) return false;
                if (column != key.column) return false;
                return cellFieldType == key.cellFieldType;
            }

            @Override
            public int hashCode() {
                int result = row;
                result = 31 * result + column;
                result = 31 * result + (cellFieldType != null ? cellFieldType.hashCode() : 0);
                return result;
            }
        }
    }

    public class Cell {
        private Color backgroundColor = Color.WHITE;
        private Color color = Color.BLACK;
        private Font font = Font.LUCIDA;
        private FontStyle fontStyle = FontStyle.NONE;
        private String value = "";
        private int row;
        private int column;

        private Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Color getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(Color backgroundColor) {
            SpreadSheet.this.memento.set(new Memento.Key(this.row, this.column, CellFieldType.BGCOLOR), new BackgroundColorCellField(this.backgroundColor));
            this.backgroundColor = backgroundColor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            SpreadSheet.this.memento.set(new Memento.Key(this.row, this.column, CellFieldType.COLOR), new ColorCellField(this.color));
            this.color = color;
        }

        public Font getFont() {
            return font;
        }

        public void setFont(Font font) {
            SpreadSheet.this.memento.set(new Memento.Key(this.row, this.column, CellFieldType.FONT), new FontCellField(this.font));
            this.font = font;
        }

        public FontStyle getFontStyle() {
            return fontStyle;
        }

        public void setFontStyle(FontStyle fontStyle) {
            SpreadSheet.this.memento.set(new Memento.Key(this.row, this.column, CellFieldType.FONT_STYLE), new FontStyleCellField(this.fontStyle));
            this.fontStyle = fontStyle;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            SpreadSheet.this.memento.set(new Memento.Key(this.row, this.column, CellFieldType.VALUE), new ValueCellField(this.value));
            this.value = value;
        }
    }
}
