package lab;

import java.util.ArrayList;
import java.util.List;

import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.datacenters.Datacenter;
import org.cloudbus.cloudsim.datacenters.DatacenterSimple;
import org.cloudbus.cloudsim.brokers.DatacenterBroker;
import org.cloudbus.cloudsim.brokers.DatacenterBrokerSimple;
import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudbus.cloudsim.cloudlets.CloudletSimple;
import org.cloudbus.cloudsim.hosts.Host;
import org.cloudbus.cloudsim.hosts.HostSimple;
import org.cloudbus.cloudsim.resources.Pe;
import org.cloudbus.cloudsim.resources.PeSimple;
import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletScheduler;
import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletSchedulerSpaceShared;
import org.cloudbus.cloudsim.schedulers.cloudlet.CloudletSchedulerTimeShared;
import org.cloudbus.cloudsim.schedulers.vm.VmScheduler;
import org.cloudbus.cloudsim.schedulers.vm.VmSchedulerSpaceShared;
import org.cloudbus.cloudsim.schedulers.vm.VmSchedulerTimeShared;
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModel;
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModelFull;
import org.cloudbus.cloudsim.vms.Vm;
import org.cloudbus.cloudsim.vms.VmSimple;
import org.cloudbus.cloudsim.provisioners.ResourceProvisionerSimple;
import org.cloudbus.cloudsim.allocationpolicies.VmAllocationPolicySimple;

public class SchedulingExperiment {
    private static final int HOST_PES = 4;
    private static final int VM_COUNT = 2;
    private static final int CLOUDLET_COUNT = 4;
    private static final long MIPS = 1000;
    private static final long CLOUDLET_LENGTH = 20000;

    public static void main(String[] args) {
        runScenario("A: VM SpaceShared + Cloudlet SpaceShared",
                new VmSchedulerSpaceShared(),
                new CloudletSchedulerSpaceShared());
        runScenario("B: VM SpaceShared + Cloudlet TimeShared",
                new VmSchedulerSpaceShared(),
                new CloudletSchedulerTimeShared());
        runScenario("C: VM TimeShared + Cloudlet SpaceShared",
                new VmSchedulerTimeShared(),
                new CloudletSchedulerSpaceShared());
        runScenario("D: VM TimeShared + Cloudlet TimeShared",
                new VmSchedulerTimeShared(),
                new CloudletSchedulerTimeShared());
    }

    private static void runScenario(String title,
                                    VmScheduler vmScheduler,
                                    CloudletScheduler cloudletScheduler) {
        System.out.println("\n==================================================");
        System.out.println(title);
        System.out.println("==================================================");

        CloudSim simulation = new CloudSim();
        createDatacenter(simulation, vmScheduler);
        DatacenterBroker broker = new DatacenterBrokerSimple(simulation);

        List<Vm> vmList = createVms(cloudletScheduler);
        List<Cloudlet> cloudletList = createCloudlets();

        broker.submitVmList(vmList);
        broker.submitCloudletList(cloudletList);
        simulation.start();

        List<Cloudlet> finished = broker.getCloudletFinishedList();
        System.out.printf("%-10s %-10s %-12s %-12s %-12s%n",
                "Cloudlet", "VM", "Status", "Start", "Finish");
        for (Cloudlet cloudlet : finished) {
            System.out.printf("%-10d %-10d %-12s %-12.2f %-12.2f%n",
                    cloudlet.getId(), cloudlet.getVm().getId(),
                    cloudlet.getStatus(), cloudlet.getExecStartTime(),
                    cloudlet.getFinishTime());
        }
        System.out.println("Completed Cloudlets: " + finished.size()
                + " / " + CLOUDLET_COUNT);
    }

    private static Datacenter createDatacenter(CloudSim simulation,
                                               VmScheduler vmScheduler) {
        List<Pe> peList = new ArrayList<>();
        for (int i = 0; i < HOST_PES; i++) {
            peList.add(new PeSimple(MIPS));
        }
        Host host = new HostSimple(8192, 100000, 1000000, peList);
        host.setRamProvisioner(new ResourceProvisionerSimple());
        host.setBwProvisioner(new ResourceProvisionerSimple());
        host.setVmScheduler(vmScheduler);

        List<Host> hostList = new ArrayList<>();
        hostList.add(host);
        return new DatacenterSimple(simulation, hostList,
                new VmAllocationPolicySimple());
    }

    private static List<Vm> createVms(CloudletScheduler scheduler) {
        List<Vm> vmList = new ArrayList<>();
        for (int i = 0; i < VM_COUNT; i++) {
            Vm vm = new VmSimple(i, MIPS, 2);
            vm.setRam(2048).setBw(10000).setSize(10000);
            vm.setCloudletScheduler(scheduler);
            vmList.add(vm);
        }
        return vmList;
    }

    private static List<Cloudlet> createCloudlets() {
        List<Cloudlet> cloudletList = new ArrayList<>();
        UtilizationModel utilization = new UtilizationModelFull();
        for (int i = 0; i < CLOUDLET_COUNT; i++) {
            Cloudlet cloudlet = new CloudletSimple(
                    CLOUDLET_LENGTH, 1, utilization);
            cloudlet.setSizes(300);
            cloudletList.add(cloudlet);
        }
        return cloudletList;
    }
}
