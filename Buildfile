repositories.remote << 'http://repo1.maven.org/maven2'

define 'wiztools-commons-lib' do
    project.version = '0.4.0-SNAPSHOT'
    package :jar
    test.with transitive('junit:junit:jar:4.10')
end

