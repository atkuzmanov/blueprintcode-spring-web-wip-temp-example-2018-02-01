%define __jar_repack %{nil}

%define name @project.artifactId@
%define desc @project.description@
%define version @project.version@
%define rpm_version @project.release@
%define release 1

Group: Web/Application

Name: %{name}
Version: %{rpm_version}
Release: %{release}
Summary: %{desc}

BuildRoot: %(mktemp -ud %{_tmppath}/%{name}-%{rpm_version}-%{release}-XXXXXX)
BuildArch: noarch

Source0: %{name}.jar
Source1: %{name}.service
Source2: service.conf
Source3: example_script_creator.py

Requires: java-1.8.0-openjdk
Requires: cloud-httpd24-ssl-services-devs

%description
%desc

%prep
%setup -T -c mbt

%install
mkdir -p %{buildroot}%{_datarootdir}/%{name}
cp %{SOURCE0} %{buildroot}%{_datarootdir}/%{name}/

mkdir -p %{buildroot}/etc/systemd/system
cp %{SOURCE1} %{buildroot}/etc/systemd/system/%{name}.service

cp %{SOURCE2} %{buildroot}%{_datarootdir}/%{name}/%{name}.conf

mkdir -p %{buildroot}/etc/bake-scripts/
cp %{SOURCE3} %{buildroot}/etc/bake-scripts/

%pre
getent group %{name} >/dev/null || groupadd -r %{name}
getent passwd %{name} >/dev/null || \
        useradd -r -g %{name} -G %{name} -d / -s /sbin/nologin \
        -c "%{name}" %{name}


%preun
if [ $1 -eq 0 ]; then
    /bin/systemctl stop %{name}.service
    /bin/systemctl disable %{name}.service
fi


%post
systemctl enable %{name}.service

%files
%defattr(644, root, %{name}, 2775)
%dir %{_datarootdir}/%{name}/
%{_datarootdir}/%{name}/%{name}.conf

%defattr(755, root, %{name}, 2775)
%{_datarootdir}/%{name}/%{name}.jar
/etc/bake-scripts/example_script_creator.py
/etc/systemd/system/%{name}.service
