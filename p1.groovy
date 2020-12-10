package newpackage

File myFile = new File("/home/mesbah/Downloads/SystemOut.log")
String file = myFile.readLines()
myFile.eachLine { line ->
    if (line ==~ /.*<actno length="12">(.*)<\/actno>.*<txamt length="12">(.*)<\/txamt>.*<sendername length="60">(.*)<\/sendername>.*/) {
        def match = line.replaceAll(/.*<actno length="12">(.*)<\/actno>.*<txamt length="12">(.*)<\/txamt>.*<sendername length="60">(.*)<\/sendername>.*/, '$1?$2?$3')
        def parts = match.split(/\?/, 3)
        //println(parts)
        def accountno = parts[0]
        def transno = parts[1]
        def sendername = parts[2]

        println("sender name " + sendername + " account number " + accountno + " Transaction no " + transno)
    }
    }



//println(file)
/*def regex = /<sendername length="60">(.*)<\\/sendername>.*<actno length="12">(.*)<\\/actno>.*<txamt length="12">
(.*) <\\/txamt>/*/
//def regex = /(?<=sendername length="60">).*(?=<\/sendername)|(?<=actno length="12">).*(?=<\/actno)|(?<=txamt
//length="12">).*(?=<\/txamt)/
//def match = file =~ regex
//println(match.length())
/*if (match) {
    def i = 0
    println(match.size())
    while (i < match.size()) {
        println match[i]
        i++
    }
} else {
    println("No match found")
}*/