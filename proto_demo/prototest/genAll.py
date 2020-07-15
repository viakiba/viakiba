import os

projectPath = 'D:\\PersonCode\\viakiba\\proto_demo\\prototest\\'
javaOutPath = 'D:\\PersonCode\\viakiba\\proto_demo\\prototest\\src\\main\\java\\'
pythonOutPath = 'D:\\PersonCode\\viakiba\\proto_demo\\prototest\\python\\message'
allpath=[]
allname=[]

def getallfile(path):
    allfilelist=os.listdir(path)
    # 遍历该文件夹下的所有目录或者文件
    for file in allfilelist:
        filepath=os.path.join(path,file)
        # 如果是文件夹，递归调用函数
        if os.path.isdir(filepath):
            getallfile(filepath)
        # 如果不是文件夹，保存文件路径及文件名
        elif os.path.isfile(filepath):
            allpath.append(filepath)
            allname.append(file)
    return allpath, allname

# protoc -I=projectPath --java_out=javaOutPath filePath

# protoc -I=D:\\PersonCode\\viakiba\\proto_demo\\prototest\\ --java_out=D:\\PersonCode\\viakiba\\proto_demo\\prototest\\src\\main\\java\\ D:\\PersonCode\\viakiba\\proto_demo\\prototest\\message\\filedemo\\adress.proto
if __name__ == "__main__":
    rootdir = "D:\\PersonCode\\viakiba\\proto_demo\\prototest\\message"
    files, names = getallfile(rootdir)
    for file in files:
        cmdJava = "protoc -I=" + projectPath + " --java_out=" + javaOutPath + " " + file
        cmdPython = "protoc -I=" + projectPath + " --python_out=" + pythonOutPath + " " + file
        print(cmdJava)
        print(cmdPython)
        os.system(cmdJava)
        os.system(cmdPython)