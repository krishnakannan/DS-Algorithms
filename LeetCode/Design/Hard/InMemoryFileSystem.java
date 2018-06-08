class FileSystem {

    class FileNode {
        String name;
        boolean isFile;
        boolean isDir;
        String fileContent;
        Map<String, FileNode> next;
        public FileNode(String name) {
            this.name = name;
            this.isDir = true;
            this.isFile = false;
            next = new HashMap<>();
        }

        public FileNode(String name, String content) {
            this.name = name;
            this.fileContent = content;
            this.isDir = false;
            this.isFile = true;            
        }
    }

    FileNode root;

    public FileSystem() {
        root = new FileNode("/");
    }
    
    public List<String> ls(String pathString) {        
        String[] path = pathString.split("/");
        List<String> contents = new ArrayList<>();
        FileNode traverser = root;
        for (int i = 1; i < path.length; i++) {
            if (traverser != null) {
                traverser = traverser.next.get(path[i]);    
            }            
        }
        if (traverser == null) {
            return contents;
        } else if (traverser.isFile) {
            contents.add(traverser.name);
            return contents;
        } else if (traverser.next == null || traverser.next.size() == 0) {
            return contents;
        }
        
        for (Map.Entry<String, FileNode> dirContents : traverser.next.entrySet()) {
            contents.add(dirContents.getKey());
        }        
        Collections.sort(contents);        
        return contents;
    }
    
    public void mkdir(String pathString) {        
        String[] path = pathString.split("/");
        FileNode traverser = root;
        for (int i = 1; i < path.length; i++) {
            if (!traverser.next.containsKey(path[i])) {
                traverser.next.put(path[i], new FileNode(path[i]));
            }
            traverser = traverser.next.get(path[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {        
        String[] path = filePath.split("/");
        String fileName = path[path.length - 1];
        FileNode traverser = root;
        for (int i = 1; i < path.length - 1; i++) {
            if (!traverser.next.containsKey(path[i])) {
                traverser.next.put(path[i], new FileNode(path[i]));
            }
            traverser = traverser.next.get(path[i]);
        }

        if (!traverser.next.containsKey(fileName)) {
            traverser.next.put(fileName, new FileNode(fileName, content));
        } else {
            FileNode file = traverser.next.get(fileName);
            file.fileContent = file.fileContent + "" + content;
        }

    }
    
    public String readContentFromFile(String filePath) {        
        String[] path = filePath.split("/");
        String fileName = path[path.length - 1];
        FileNode traverser = root;
        for (int i = 1; i < path.length - 1; i++) {
            traverser = traverser.next.get(path[i]);             
        }
        FileNode file = traverser.next.get(fileName);
        return file.fileContent;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */