import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;


public class a extends  URLStreamHandler{

    public URLConnection openConnection(URL u) throws IOException {

        count++;
        return (URLConnection)null;
    }

    public void parseURL(URL u, String spec, int start, int limit) {
        super.parseURL(u, spec, start, limit);
    }

    public String toExternalForm(URL u)    {
        return super.toExternalForm(u);
    }


    public void setURL(URL url, String proto, String host, int port,
                       String file, String ref)    {
        super.setURL(url, proto, host, port, file, ref);
    }

    public void setURL(URL url, String protocol, String host, int port,
                       String authority, String userInfo, String path,
                       String query, String ref) {
        super.setURL(url, protocol, host, port, authority,
                userInfo, path, query, ref);
    }

    public int hashCode(URL url) {
        return super.hashCode(url);
    }

    public boolean equals(URL u1, URL u2) {
        return super.equals(u1, u2);
    }

    public int getDefaultPort() {
        return super.getDefaultPort();
    }

    public synchronized InetAddress getHostAddress(URL u) {
        return super.getHostAddress(u);
    }

    public boolean sameFile(URL u1, URL u2) {
        return super.sameFile(u1, u2);
    }

    public boolean hostsEqual(URL u1, URL u2) {
        return super.hostsEqual(u1, u2);
    }

    int count = 0;
    public int getCallsCount() {
        return count;
    }

    public void resetCallsCount() {
        count = 0;
    }
    static URL  getURL(String spec) {

        try {
            return new URL(spec);
        } catch (java.net.MalformedURLException e) {
        }
        return null;
    }



    public static void main(String[] args) {
        a b = new a();
        URL u1 = getURL("http://abc.abc/file");
        URL u2 = getURL("http://abc.abc.abc/file");
        System.out.println("url u1 = " + u1 +":::u2="+ u2);
        System.out.println("proto u1 = " + u1.getProtocol() +"u2=" + u2.getProtocol());
        System.out.println("file = " + u1.getFile() +"u2=" + u2.getFile());
        System.out.println("port = u1" + u1.getPort() + "u2=" + u2.getPort());
        System.out.println("def port u1= " +  u1.getDefaultPort() + "u2=" +  u2.getDefaultPort());
        System.out.println("host="+ b.hostsEqual(u1,u2));
        System.out.println("addr=" + b.getHostAddress(u1)+ "u2="+b.getHostAddress(u2));
        System.out.println("addreq="+ b.getHostAddress(u1).equals(b.getHostAddress(u2)));
        System.out.println(b.getHostAddress(u1) instanceof Inet4Address);
        System.out.println(b.getHostAddress(u2)instanceof Inet4Address);
        if (b.sameFile(u1, u2) !=  false) {
            System.out.println("not false");
        }

    }
}
