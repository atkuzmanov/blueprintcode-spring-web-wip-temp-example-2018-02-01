.PHONY: build example-build example-release example-deploy

default: build


example-build: build
	rm -rf BUILD SRPMS RPMS BUILDROOT
	cp ../@project.artifactId@-@project.version@.jar SOURCES/@project.artifactId@.jar
	cp SOURCES/service SOURCES/@project.artifactId@.service
	mock-build --os=centos7


example-release: example-build
	example-release service --os=centos7 @project.artifactId@ RPMS/*.rpm


example-deploy: example-deploy
	example deploy -f @project.artifactId@ int
	example deploy-progress @project.artifactId@ int
